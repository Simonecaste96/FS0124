package it.epicode.u5w2d2esercizio.controller;

import it.epicode.u5w2d2esercizio.Dto.BlogDto;
import it.epicode.u5w2d2esercizio.exception.BadRequestException;
import it.epicode.u5w2d2esercizio.exception.BlogNonTrovatoException;
import it.epicode.u5w2d2esercizio.model.Blog;
import it.epicode.u5w2d2esercizio.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BlogController {


    @Autowired
    BlogService blogService;

    //ottengo la lista dei blog
    @GetMapping("/blogPosts")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<Blog> getListBlogs(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "15") int size,
                                   @RequestParam(defaultValue = "id") String sortBy){
        return blogService.getAllBlogs(page,size,sortBy);
    }

    //ricerco il blog per id
    @GetMapping("/blogPosts/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Blog getPostById(@PathVariable int id)throws BlogNonTrovatoException {
        Optional<Blog> blogBody = blogService.getBlogById(id);
        if(blogBody.isPresent()){
            return blogBody.get();
        }else{
            throw new BlogNonTrovatoException("Nessun blog non trovato per il seguente id:"+ id);
        }
    }

    //creo il blog
    @PostMapping("/blogPosts")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveBlog(@RequestBody @Validated BlogDto blogDto, BindingResult bindingResult){
   if(bindingResult.hasErrors()){
       throw new BadRequestException(bindingResult.getAllErrors().stream().
               map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
   }
        return blogService.saveBlog(blogDto);
    }

//aggiorno il blog
    @PutMapping("/blogPosts/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog updateBlog(@PathVariable int id,@RequestBody @Validated BlogDto blogDto,BindingResult bindingResult) throws BlogNonTrovatoException{
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }
        return blogService.updateBlog(id,blogDto);
    }

@PatchMapping("/updateInfo/blogPosts/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  Blog updateParseBlog(@PathVariable int id,@RequestBody @Validated Map<String, Object> blogParse,BindingResult bindingResult) throws BlogNonTrovatoException{
    if(bindingResult.hasErrors()){
        throw new BadRequestException(bindingResult.getAllErrors().stream().
                map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
    }
        return blogService.updateBlogParse(id,blogParse);
}


    @PatchMapping("/updateCover/blogPosts/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  String updateCoverBlog(@PathVariable int id,@RequestBody MultipartFile cover) throws IOException {
        return blogService.uploadCoverBlog(id,cover);
    }

@DeleteMapping("/blogPosts/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteBlog(@PathVariable int id)throws BlogNonTrovatoException{
        return blogService.deleteBlog(id);
}

}
