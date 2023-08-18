# Idea
Il progetto riguarda un social network distraction free cioè privo di distrazioni come
le pubblicità, animazioni e qualsiasi altro accorgimento per distogliere l’attenzione dell’utilizzatore quindi, i contenuti, sono tutti volutamente testuali anche eventualmente le immagini. Sul social è possibile aggiungere dei post. I post sono visti come aggregazione di dati, testo e immagini , comunque, il social rimane espandibile per l’aggiunta di eventuali altri tipi di contenuti. E’ anche possibile aggiungere dei post all’interno di altri post quindi un annidamento di post, l’idea è che questi possano essere visualizzati in maniera opportuna in base alla volontà dell’implementatore.
Ogni utente è rappresentato da un profilo, per semplicità non è prevista autenticazione, questi profili possono essere “seguiti” da altri profili per ricevere delle notifiche nel momento in cui viene pubblicato/rimosso un post ma, anche i post stessi possono essere seguiti per ricevere notifiche sull’eventuale aggiunta/rimozione di contenuti interni al post stesso. Sarà quindi presente un servizio di notifica per gli iscritti ad
un post/profilo che, a seconda del tipo di oggetto seguito, manderà una notifica con un formato diverso.
# Pattern Applicati
I design pattern che sono stati utilizzati nel progetto sono:
- Observer
- Composite
- Visitor
- Iterator
  
In particolare il pattern Visitor è stato applicato due volte in due situazioni diverse: la prima, per la visita dei componenti del composite, la seconda, per la visita degli eventi generati per gli observer, queste scelte di design verranno approfondite nella sezione seccessiva.

Schema UML riassuntivo:

![image](https://github.com/guglielmobartelloni/Java-Advanced-Design-Pattern-Project/assets/18078381/b3ccce42-333f-4f32-86c3-d482bb28ae9a)

# Scelte di Design
Come detto in precedenza i pattern che sono stati utilizzati sono quattro di seguito è presente un approfondimento sulle scelte che hanno portato all’utilizzo di quest’ultimi.

## Composite

Questo pattern è il pattern che dà la struttura ad alcuni componenti del progetto. In particolare i componenti “postabili”, cioè quelli che possono essere considerati come contenuto del social network, sono tutti accomunati da una interfaccia “Postable” che è il “Component” del pattern Composite. L’interfaccia “Postable” mette a disposizione un metodo getContent che ritorna una stringa: questo metodo sarà utilizzato per la visualizzazione del contenuto dei componenti. Il fatto che il metodo ritorni una stringa è congruo al fatto che i contenuti sono solamente visualizzati sottoforma di testo come da specifica.

Le “foglie” della gerarchia del Composite sono rappresentate dalle classi PostableText e PostableAsciiImage una, permette di inserire del testo l’altra, permette di inserire delle immagini testuali rappresentate da una matrice di caratteri. Di queste classi sono stati testati i metodi getContent ed anche il ritorno di un IllegalArgumentException se il testo è vuoto, per PostableText, e se l’array di caratteri passato risulta essere null, per PostableAsciiImage.

Il “Composite” è rappresentato invece dalla classe Post, questa classe ha una collezione di Postable ed un titolo, nel metodo getContent viene utilizzato un Visitor per visitare tutti i suoi figli ritornando una stringa. Dato che anche la classe Post implementa Postable, all’interno di un Post possono essere inseriti altri post, questo è contemplato dalle specifiche. E’ presente anche l’applicazione del pattern Iterator per ritornare la collezione dei contenuti del post. La variante Composite utilizzata è la variante “Type Safe”, quindi la gestione dei figli è demandata alla classe Post.

Sono stati testati tutti i metodi delle classi sopra elencate compresi i metodi di gestione dei figli per Post.

## Visitor

Gli eventi dei contenuti del social network sono tutti accomunati dalla classe astratta SocialEvent che ha come parametro del costruttore un Postable, questo è utilizzato nel Visitor per poter avere informazioni sul contenuto che ha generato l’evento inoltre, dato che gli eventi dovranno essere visitati dai Visitor è presente il metodo accept che prende come parametro un SocialEventVisitor. Sono presenti poi quattro sottoclassi di SocialEvent che rappresentano i vari eventi:
- AddedPostEvent: aggiunta di un post da parte di un profilo
- RemovedPostEvent: rimozione di un post da parte di un profilo
- AddedContentToPostEvent: aggiunta di un contenuto (Postable) ad un Post
- RemovedContentToPostEvent: rimozione di un contenuto (Postable) da un Post


La scelta dell’utilizzo del Visitor nel caso degli eventi è derivata dal fatto che, a seconda del tipo concreto dell’evento, dovrà essere generato un messaggio diverso per la notifica agli observer. La variante del Visitor utilizzata in questo caso è quella void, per questo i Visitor hanno uno stato interno. L’interfaccia SocialEventVisitor è l’interfaccia per la visita degli eventi ed è implementata dalla classe SocialEventNotifierVisitor, questa classe ha come variabili di istanza un NotificationSender e un recipient, che sono rispettivamente l’interfaccia per l’invio di notifiche e il destinatario della notifica. NotificationSender è, un’astrazione dell’invio di una notifica che ha un metodo send che ha come parametro il messaggio da inviare e il destinatario (recipient).

Dato che anche i Postable devono essere visitati in modo differente a seconda del loro tipo, anch’essi utilizzano il pattern Visitor. In questo caso la variante utilizzata è quella con tipo generico in quanto questa permette di avere maggiore flessibilità nell’aggiunta di futuri Visitor concreti.

PostableRecursivePrintVisitor è l’implementazione dell’interfaccia PostableVisitor cioè il Visitor per i Postable. Come detto questo Visitor visita tutti i componenti postabili del social network e a seconda del tipo concreto di questi, esegue un’operazione diversa. In particolare PostablePrintVisitor stampa i Postable nel seguente modo:
- PostableImage: Image: [contenuto dell’immagine]
- PostableText: [contenuto del testo]
- Post: [titolo] [contenuto del post ricorsivamente]
  
E’ anche presente una versione non ricorsiva di questo Visitor PostableNonRecursivePrintVisitor che, quando trova un post all’interno di un altro post, stampa semplicemente il titolo
senza i suoi sottocontenuti. Sono stati testati i metodi di visita per entrambi i Visitor.

## Observer

Il pattern Observer è utilizzato nel progetto per notificare i cambiamenti nei contenuti del social network. In particolare, è presente l’interfaccia SocialObserver e la classe astratta SocialSubject. La classe Profile implementa l’interfaccia SocialObserver in quanto un profilo, dopo essersi aggiunto come follower per un altro profilo, dovrà essere notificato per l’aggiunta o la rimozione di un post. Infatti Profile possiede una collezione di Post, ogni volta che la collezione viene modificata vengono notificati gli altri profili mediante la creazione di un evento apposito (addedPostEvent-removedPostEvent) per questo, un profilo è anche un subject con un metodo notifyObservers che tramite un Visitor, si occupa di mandare un messaggio diverso a seconda del tipo concreto dell’evento generato. Le notifiche vengono mandate da un servizio chiamato NotificationSender che è rappresentato da un’interfaccia che è stata testata con un “Mock” apposito.

La classe Post è un altra classe che estende SocialSubject perchè un profilo pu`o seguire anche un post per ricevere notifiche sull’aggiunta/rimozione di un contentuto. Le operazioni presenti in Post per la gestione degli observer sono le medesime delle operazioni presenti in Profile perchè derivate dalla classe astratta SocialSubject.

Di queste classi sono stati testati i metodi attach/detach ed anche la generazione degli eventi e l’invio delle notifiche tramite un MockNotificationSender, che salva la notifica all’interno di una stringa per essere testata.
