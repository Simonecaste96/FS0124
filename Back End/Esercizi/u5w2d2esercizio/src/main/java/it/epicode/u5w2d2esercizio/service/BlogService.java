package it.epicode.u5w2d2esercizio.service;

import com.cloudinary.Cloudinary;
import it.epicode.u5w2d2esercizio.Dto.BlogDto;
import it.epicode.u5w2d2esercizio.exception.AutoreNonTrovatoException;
import it.epicode.u5w2d2esercizio.exception.BlogNonTrovatoException;
import it.epicode.u5w2d2esercizio.model.Autore;
import it.epicode.u5w2d2esercizio.model.Blog;
import it.epicode.u5w2d2esercizio.repository.AutoreRepository;
import it.epicode.u5w2d2esercizio.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
public class BlogService {
    //private List<Blog> blogs = new ArrayList<>();

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;


    public Optional<Blog> getBlogById(int id) {
        return blogRepository.findById(id);
    }


    public Page<Blog> getAllBlogs(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return blogRepository.findAll(pageable);
    }

    public String saveBlog(BlogDto blogDto)throws BlogNonTrovatoException {
        Blog blog =  new Blog();
        blog.setCategoria(blogDto.getCategoria());
        blog.setTitolo(blogDto.getTitolo());
        blog.setContenuto(blogDto.getContenuto());
        blog.setTempoDiLettura(Duration.ofMinutes(blogDto.getTempoDiLettura()));
        blog.setCover(blogDto.getCover());


        Optional<Autore> autoreOptional = autoreRepository.findById(blogDto.getAutoreId());

        if(autoreOptional.isPresent()){
            Autore autore = autoreOptional.get();
            blog.setAutore(autore);
            autoreRepository.save(autore);
            blogRepository.save(blog);
            sendMailCreationBlog(autore.getEmail());
            return "Blog salvato con matricola: "+blog.getId()+ " salvato";
        }else{
            throw new BlogNonTrovatoException("Impossibile aggiungere uno blog se l'autore con l'id inserito non esiste: crea prima l'autore ed inserisci il suo id");
        }
    }

    public Blog updateBlog(int id,BlogDto blogDto) {
        Optional<Blog> blogOpt = getBlogById(id);
        if (blogOpt.isPresent()) {
            Blog blog = blogOpt.get();

            blog.setTitolo(blogDto.getTitolo());
            blog.setContenuto(blogDto.getContenuto());
            blog.setCategoria(blogDto.getCategoria());
            blog.setTempoDiLettura(Duration.ofMinutes(blogDto.getTempoDiLettura()));
            blog.setCover(blogDto.getCategoria());

            Optional<Autore> autoreOptional = autoreRepository.findById(blogDto.getAutoreId());
            if (autoreOptional.isPresent()) {
                Autore autore = autoreOptional.get();
                blog.setAutore(autore);
                blogRepository.save(blog);
                return blog;
            }
        else {
            throw new AutoreNonTrovatoException("Autore con id: " + blogDto.getAutoreId() + " non trovato");
        }
    }
    else{
           throw new BlogNonTrovatoException("Blog con id: " + id + " non trovato");
      }
    }


    public Blog updateBlogParse(int id, Map<String, Object> update) throws BlogNonTrovatoException {
        Optional<Blog> blogOpt = getBlogById(id);
        if (blogOpt.isPresent()) {
            Blog blog = blogOpt.get();

            update.forEach((key, value) -> {
                switch (key) {
                    case "categoria":
                        blog.setCategoria((String) value);
                        break;
                    case "titolo":
                        blog.setTitolo((String) value);
                        break;
                    case "cover":
                        blog.setCover((String) value);
                        break;
                    case "contenuto":
                        blog.setContenuto((String) value);
                        break;
                    case "tempoDiLettura":
                        blog.setTempoDiLettura(Duration.ofMinutes((Long) value));
                        break;
                    default:
                        throw new IllegalArgumentException("Campo non valido: " + key);
                }
            });
            blogRepository.save(blog);
            return blog;
        } else {
            throw new BlogNonTrovatoException("Blog post non trovato con id: " + id);
        }
    }


        public String deleteBlog (int id) throws BlogNonTrovatoException {
            Optional<Blog> blogOpt = getBlogById(id);

            if (blogOpt.isPresent()) {
                blogRepository.delete(blogOpt.get());
                return "Blog con id="+ id + " eliminato";
            } else {
                throw new BlogNonTrovatoException("Blog non trovato");
            }


        }


    public String uploadCoverBlog(int id, MultipartFile foto) throws BlogNonTrovatoException, IOException {
        Optional<Blog> blogOptional = getBlogById(id);
        if (blogOptional.isPresent()){
            String url =(String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Blog blog = blogOptional.get();
            blog.setCover(url);
            blogRepository.save(blog);
            return "Cover blog salvata!";
        }else{
            throw new BlogNonTrovatoException("Impossibile impostare la cover del blog, non è stato trovato nessun blog con la matricola: "+id);
        }
    }



    private void sendMailCreationBlog(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Blog creato con successo!");
        message.setText("Blog creato con successo!");

        javaMailSenderImpl.send(message);
    }

    }

