# BW3-Gruppo5

## DESCRIZIONE PROGETTO

Questo progetto è un'applicazione web basata su Angular che consente agli utenti di pubblicare, modificare, creare ed eliminare post. Gli utenti devono autenticarsi per accedere all'applicazione e utilizzare le sue funzionalità

## INSTALLAZIONE

#### 1. Assicurati di avere Node.js installato sul tuo sistema.

#### 2. Clona questo repository sul tuo computer utilizzando il comando:

```bash
git clone https://github.com/TunaSandwichhh/BW3-Gruppo5.git
```

#### 3. Naviga nella directory del progetto tramite il terminale:

```bash
cd bw3-crud
```

#### 4. Installa le dipendenze del progetto eseguendo il comando:

```bash
npm install
```

#### 5. Avvia l'applicazione utilizzando il comando:

```bash
npm start
```

#### 6. Apri il tuo browser e vai all'indirizzo http://localhost:4200/ per visualizzare l'applicazione in esecuzione.

## ROUTES

### L'applicazione utilizza le seguenti rotte per la navigazione:

##### '/' Pagina iniziale dell'applicazione, che mostra il contenuto principale.

##### '/login': Pagina di accesso per gli utenti registrati.

##### '/signup': Pagina di registrazione per nuovi utenti.

##### '/posts': Pagina principale dei post, accessibile solo agli utenti autenticati.

##### 'posts/new-post': Pagina per la creazione di un nuovo post.

##### 'posts/details/:id': Pagina che mostra i dettagli di un post specifico.

##### 'posts/edit/:id': Pagina per modificare un post esistente.

##### '\*\*': Rotta fallback che viene visualizzata quando l'URL non corrisponde a nessuna delle rotte definite sopra.

## COMPONENTS

### error-page

Mostra la pagina di errore come fallback 404.

### home-page

Mostra la homepage da cui l'utente viene reindirizzato a login o signup.

### login

Componente che contiene un reactive form di login. I dati vengono impacchettati in un oggetto di tipo LoginRequestBody e inviati al service appropriato.

### navbar

Componente della navbar. Se l'utente è autenticato, mostra i pulsanti "Home" e "Logout"; altrimenti mostra "Signup" e "Signin".

### posts-page

Mostra tutti i post presenti nel database, con i seguenti sotto-componenti:<br>
<br>edit-page: Pagina di modifica del post.
<br>new-post-page: Pagina di creazione di un nuovo post.
<br>post-details: Pagina in cui viene visualizzato il singolo post.

### signup

Reactive form di registrazione. I dati vengono raccolti e impacchettati sotto forma di SignupRequestBody e inviati al service.

## SERVICES

### AuthService

Questo servizio gestisce l'autenticazione degli utenti.<br>
Fornisce funzionalità per la registrazione, l'accesso e il logout degli utenti.<br>
Utilizza HttpClient per effettuare richieste HTTP alle API di autenticazione fornite da Google Firebase.<br>
Gestisce lo stato di autenticazione degli utenti tramite la proprietà isLoggedIn.<br>
Implementa metodi per le funzionalità di signup, login e logout<br>

### PostsService:

Questo servizio gestisce le operazioni sui post dell'applicazione.<br>
Fornisce funzionalità per ottenere, creare, aggiornare ed eliminare i post.<br>
Utilizza HttpClient per effettuare richieste HTTP al server backend locale.<br>
Implementa metodi come getPosts, getPost, createPost, updatePost e deletePost.<br>

## DATABASE

Il progetto utilizza Firebase RealTime Database come database per immagazzinare tutti i post dell'applicazione. RealTime Database è uno strumento semplice per creare rapidamente una API RESTful. Nel nostro caso, RealTime Database ci consente di simulare un backend per gestire i dati dei post.<br><br>

<br>
Sarà possibile accedere ai dati dei post attraverso le relative API RESTful all'indirizzo https://bw3-gruppo6-default-rtdb.europe-west1.firebasedatabase.app/posts.

## AUTENTICAZIONE

L'applicazione utilizza Firebase per gestire l'autenticazione degli utenti. Firebase offre un'implementazione semplice e sicura dell'autenticazione tramite email/password, consentendo agli utenti di creare un account e accedere all'applicazione in modo sicuro.

Per registrarsi o accedere, gli utenti possono utilizzare la procedura standard di Firebase, che include la compilazione di un modulo con email e password. Una volta completata la procedura di registrazione o accesso, Firebase fornisce un token di autenticazione che viene utilizzato per verificare l'identità dell'utente nelle successive richieste.

Firebase gestisce anche automaticamente la validità delle password, garantendo che siano sicure e aggiornate secondo le best practice di sicurezza.

## BUILD & HOSTING
<div>
 <img src="https://user-images.githubusercontent.com/25181517/117447155-6a868a00-af3d-11eb-9cfe-245df15c9f3f.png" width="75px">
 &nbsp;
<img src="https://user-images.githubusercontent.com/25181517/183890595-779a7e64-3f43-4634-bad2-eceef4e80268.png" width="75px">
 &nbsp;
<img src="https://user-images.githubusercontent.com/25181517/183890598-19a0ac2d-e88a-4005-a8df-1ee36782fde1.png" width="75px">
 &nbsp;
<img src="https://user-images.githubusercontent.com/25181517/192108891-d86b6220-e232-423a-bf5f-90903e6887c3.png" width="75px">
 &nbsp;
<img src="https://user-images.githubusercontent.com/25181517/192158954-f88b5814-d510-4564-b285-dff7d6400dad.png" width="75px">
 &nbsp;
<img src="https://user-images.githubusercontent.com/25181517/183898674-75a4a1b1-f960-4ea9-abcb-637170a00a75.png" width="75px">
 &nbsp;
<img src="https://user-images.githubusercontent.com/25181517/192158956-48192682-23d5-4bfc-9dfb-6511ade346bc.png" width="75px">
 &nbsp;
<img src="./bw3-crud/src/assets/awslogo.png" width="100px"> 
</div>


L'applicazione è stata distribuita su AWS Amplify utilizzando la cartella dist generata dopo l'esecuzione del comando ng build. La cartella dist contiene tutti i file statici necessari per l'esecuzione dell'applicazione Angular.

L'applicazione è attualmente ospitata su AWS Amplify all'URL seguente:

https://dev.d321ln9pwk52yz.amplifyapp.com/

<br><br>

## Collaboratori

- [Ferdinando Di Nocera](https://github.com/fdinocera)🖥️
- [Mishel Cakalli](https://github.com/MishelCakalli)🪒
- [Rosa Giordano](https://github.com/Rosannag16)✨
- [Simone Castelluccio](https://github.com/Simonecaste96)🔨
- [Paola Del Vecchio](https://github.com/smoulderpipe)🔬
- [Davide Faggionato](https://github.com/TunaSandwichhh)🤖
