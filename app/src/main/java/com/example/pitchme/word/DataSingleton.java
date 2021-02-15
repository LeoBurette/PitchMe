package com.example.pitchme.word;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class DataSingleton{
    String[] word = {" classe", " angle", " armoire", " banc", " bureau", " cabinet", " carreau", " chaise", " classe", " clé", " coin", " couloir", " dossier", " eau", " école", " écriture", " entrée", " escalier", " étagère", " étude", " extérieur", " fenêtre", " intérieur", " lavabo", " lecture", " lit", " marche", " matelas", " maternelle", " meuble", " mousse", " mur", " peluche", " placard", " plafond", " porte", " portemanteau", " poubelle", " radiateur", " rampe", " récréation", " rentrée", " rideau", " robinet", " salle", " savon", " serrure", " serviette", " siège", " sieste", " silence", " sol", " sommeil", " sonnette", " sortie", " table", " tableau", " tabouret", " tapis", " tiroir", " toilette", " vitre", " w.-c.", " aller", " amener", " apporter", " appuyer", " asseoir|s’asseoir", " attendre", " bâiller", " bosser", " coucher|se coucher", " dormir", " éclairer", " écrire", " emmener", " emporter", " endormir|s’endormir", " ennuyer|s’ennuyer", " entrer", " étudier", " fermer", " frapper", " installer|s’installer", " lever|se lever", " lire", " ouvrir", " presser|se presser", " réchauffer|se réchauffer", " rentrer", " reposer|se reposer", " rester", " réveiller|se réveiller", " sonner", " sortir", " tricher", " venir", " absent", " assis", " bas", " couché", " haut", " présent", " à côté", " à droite", " à gauche", " au milieu", " au-delà", " au-dessous", " au-dessus", " debout", " dedans", " dehors", " en bas", " en face", " en haut", " loin", " près", " tard", " tôt", " à", " après", " au", " avant", " contre", " dans", " de", " derrière", " devant", " du", " sous", " sur", " travail", " crayon", " stylo", " feutre", " taille-crayon", " pointe", " mine", " gomme", " dessin", " coloriage", " rayure", " peinture", " pinceau", " couleur", " craie", " papier", " feuille", " cahier", " carnet", " carton", " ciseaux", " découpage", " pliage", " pli", " colle", " affaire", " boîte", " casier", " caisse", " trousse", " cartable", " jouet", " jeu", " pion", " dé", " domino", " puzzle", " cube", " perle", " chose", " forme", " carré", " rond", " pâte à modeler", " tampon", " livre", " histoire", " bibliothèque", " image", " album", " titre", " bande dessinée", " conte", " dictionnaire", " magazine", " catalogue", " page", " ligne", " mot", " enveloppe", " étiquette", " carte d’appel", " affiche", " alphabet", " appareil", " caméscope", " cassette", " cédé", " cédérom", " chaîne", " chanson", " chiffre", " contraire", " différence", " doigt", " écran", " écriture", " film", " fois", " idée", " instrument", " intrus", " lettre", " liste", " magnétoscope", " main", " micro", " modèle", " musique", " nom", " nombre", " orchestre", " ordinateur", " photo", " point", " poster", " pouce", " prénom", " question", " radio", " sens", " tambour", " télécommande", " téléphone", " télévision", " trait", " trompette", " voix", " xylophone", " zéro", " chanter", " chercher", " choisir", " chuchoter", " coller", " colorier", " commencer", " comparer", " compter", " construire", " continuer", " copier", " couper", " déchirer", " décoller", " décorer", " découper", " demander", " démolir", " dépêcher|se dépêcher", " dessiner", " dire", " discuter", " écouter", " écrire", " effacer", " entendre", " entourer", " envoyer", " faire", " finir", " fouiller", " goûter", " imiter", " laisser", " lire", " mettre", " montrer", " ouvrir", " parler", " peindre", " plier", " poser", " prendre", " préparer", " ranger", " réciter", " recommencer", " regarder", " remettre", " répéter", " répondre", " sentir", " souligner", " tailler", " taire|se taire", " tenir", " terminer", " toucher", " travailler", " trier", " autre", " ami", " attention", " camarade", " colère", " copain", " coquin", " dame", " directeur", " directrice", " droit", " effort", " élève", " enfant", " fatigue", " faute", " fille", " garçon", " gardien", " madame", " maître", " maîtresse", " mensonge", " ordre", " personne", " retard", " sourire", " travail", " aider", " défendre", " désobéir", " distribuer", " échanger", " excuser|s’excuser", " expliquer", " fâcher|se fâcher", " gronder", " obéir", " obliger", " partager", " prêter", " priver", " promettre", " punir", " quitter|se quitter", " raconter", " refuser", " séparer", " blond", " brun", " calme", " curieux", " différent", " doux", " énervé", " gentil", " grand", " handicapé", " inséparable", " jaloux", " moyen", " muet", " noir", " nouveau", " petit", " poli", " propre", " roux", " sage", " sale", " sérieux", " sourd", " tranquille", " jeu", " arrosoir", " assiette", " balle", " bateau", " boîte", " bouchon", " bouteille", " bulle", " canard", " casserole", " cuillère", " cuvette", " douche", " entonnoir", " goutte", " litre", " moulin", " pluie", " poisson", " pont", " pot", " roue", " sac", " plastique", " saladier", " seau", " tablier", " tasse", " trou", " verre", " agiter", " amuser|s’amuser", " arroser", " attraper", " avancer", " baigner", " barboter", " boucher", " bouger", " déborder", " doucher", " éclabousser", " essuyer", " envoyer", " flotter", " gonfler", " inonder", " jouer", " laver", " mélanger", " mouiller", " nager", " patauger", " pleuvoir", " plonger", " pousser", " pouvoir", " presser", " recevoir", " remplir", " renverser", " sécher", " serrer", " souffler", " tirer", " tourner", " tremper", " verser", " vider", " vouloir", " amusant", " chaud", " froid", " humide", " intéressant", " mouillé", " sec", " transparent", " à moitié", " autant", " beaucoup", " encore", " moins", " peu", " plus", " trop", " déguisement", " à l’endroit", " à l’envers", " anorak", " arc", " bagage", " baguette", " barbe", " bonnet", " botte", " bouton", " bretelle", " cagoule", " casque", " casquette", " ceinture", " chapeau", " chaussette", " chausson", " chaussure", " chemise", " cigarette", " col", " collant", " couronne", " cravate", " culotte", " écharpe", " épée", " fée", " flèche", " fusil", " gant", " habit", " jean", " jupe", " lacet", " laine", " linge", " lunette|lunettes", " magicien", " magie", " maillot", " manche", " manteau", " mouchoir", " moufle", " nœud", " paire", " pantalon", " pied", " poche", " prince", " pull-over", " pyjama", " reine", " robe", " roi", " ruban", " semelle", " soldat", " sorcière", " tache", " taille", " talon", " tissu", " tricot", " uniforme", " valise", " veste", " vêtement", " changer|se changer", " chausser|se chausser", " couvrir|se couvrir", " déguiser|se déguiser", " déshabiller|se déshabiller", " enlever", " habiller|s’habiller", " lacer", " porter", " ressembler", " clair", " court", " étroit", " foncé", " joli", " large", " long", " multicolore", " nu", " usé", " bien", " mal", " mieux", " presque", " bricolage", " aiguille", " ampoule", " avion", " bois", " bout", " bricolage", " bruit", " cabane", " carton", " clou", " colle", " crochet", " élastique", " ficelle", " fil", " marionnette", " marteau", " métal", " mètre", " morceau", " moteur", " objet", " outil", " peinture", " pinceau", " planche", " plâtre", " scie", " tournevis", " vis", " voiture", " véhicule", " arracher", " attacher", " casser", " coudre", " détruire", " écorcher|s’écorcher", " enfiler", " enfoncer", " fabriquer", " mesurer", " percer", " pincer|se pincer", " réparer", " réussir", " servir", " taper", " trouer", " adroit", " difficile", " dur", " facile", " lisse", " maladroit", " pointu", " rugueux", " tordu", " garage", " train", " accident", " aéroport", " auto", " camion", " engin", " feu", " frein", " fusée", " garage", " gare", " grue", " hélicoptère", " moto", " panne", " parking", " pilote", " pneu", " quai", " train", " virage", " vitesse", " voyage", " wagon", " zigzag", " arrêter|s’arrêter", " atterrir", " bouder", " charger", " conduire", " démarrer", " disparaître", " donner", " écraser", " envoler|s’envoler", " garder", " garer|se garer", " manquer", " partir", " poser|se poser", " reculer", " rouler", " tendre", " transporter", " voler", " abîmé", " ancien", " blanc", " bleu", " cassé", " cinq", " dernier", " deux", " deuxième", " dix", " gris", " gros", " huit", " jaune", " même", " neuf", " pareil", " premier", " quatre", " rouge", " sept", " seul", " six", " solide", " trois", " troisième", " un", " vert", " au-dessus", " autour", " vite", " à côté de", " au milieu de", " au-dessous de", " au-dessus de", " autour de", " avec", " en bas de", " en haut de", " loin de", " près de", " sur", " vers", " salle de jeux", " acrobate", " arrêt", " arrière", " barre", " barreau", " bord", " bras", " cerceau", " chaise|chaises", " cheville", " chute", " cœur", " corde", " corps", " côté", " cou", " coude", " cuisse", " danger", " doigt|doigts", " dos", " échasse|échasses", " échelle", " épaule", " équipe", " escabeau", " fesse", " filet", " fond", " genou", " gymnastique", " hanche", " jambe|jambes", " jeu", " main|mains", " milieu", " montagne", " mur d’escalade", " muscle", " numéro", " ongle", " parcours", " pas", " passerelle", " pente", " peur", " pied|pieds", " plongeoir", " poignet", " poing", " pont de singe", " poutre d’équilibre", " prise|prises", " rivière des crocodiles", " roulade", " saut", " serpent", " sport", " suivant", " tête", " toboggan", " tour", " trampoline", " tunnel", " ventre", " accrocher|s’accrocher", " appuyer|s’appuyer", " arriver", " baisser|se baisser", " balancer|se balancer", " bondir", " bousculer", " cogner|se cogner", " courir", " danser", " dépasser", " descendre", " écarter", " escalader", " gagner", " gêner", " glisser", " grimper", " marcher à quatre pattes", " marcher sur", " se mettre debout", " monter", " pencher|se pencher", " percher|se percher", " perdre", " ramper", " rater", " remplacer", " respirer", " retourner|se retourner", " revenir", " sauter", " soulever", " suivre", " tomber", " transpirer", " traverser", " dangereux", " épais", " fort", " gauche", " groupé", " immobile", " rond", " serré", " souple", " au delà", " ensemble", " ici", " jamais", " là", " souvent", " toujours", " cour", " bagarre", " balançoire", " ballon", " bande", " bicyclette", " bille", " cadenas", " cage à écureuil", " cerf-volant", " château", " coup", " cour", " course", " échasse", " flaque", " paix", " pardon", " partie", " pédale", " pelle", " pompe", " préau", " raquette", " rayon", " récréation", " sable", " sifflet", " signe", " tas", " tricycle", " tuyau", " vélo", " filet", " bagarrer|se bagarrer", " battre|se battre", " cacher|se cacher", " cracher", " creuser", " crier", " dégonfler|se dégonfler", " disputer|se disputer", " empêcher", " galoper", " hurler", " jongler", " lancer", " pédaler", " plaindre|se plaindre", " pleurer", " poursuivre", " protéger", " saigner", " salir|se salir", " siffler", " surveiller", " traîner", " trouver", " caché", " fou", " méchant", " gâteau|Gâteaux", " crêpe", " allumette", " anniversaire", " appétit", " beurre", " coquille", " crêpe|crêpes", " croûte", " dessert", " envie", " faim", " fève", " four", " galette", " gâteau", " goût", " invitation", " langue", " lèvre|lèvres", " liquide", " louche", " mie", " moitié", " moule", " odeur", " œuf", " part", " pâte", " pâtisserie", " recette", " rouleau", " sel", " soif", " tarte", " tranche", " yaourt", " aimer", " allumer", " avaler", " battre", " brûler|se brûler", " chauffer", " cuire", " étaler", " éteindre", " falloir", " inviter", " jeter", " lécher", " oublier", " régaler|se régaler", " remercier", " remuer", " souhaiter", " sucer", " barbouillé", " demi", " égal", " entier", " gourmand", " mauvais", " meilleur", " mince", " salade de fruits|Salade de fruits", " glaçon", " jus", " kiwi", " lame", " mûre", " noyau", " paille", " pamplemousse", " râpe", " croquer", " éplucher", " râper", " bassine", " cocotte", " épluchure", " légume", " pomme de terre", " rondelle", " soupe", " consommé", " potage", " bouillir", " mixer", " cru", " cuit", " vide", " cantine", " arête", " frite", " gobelet", " jambon", " os", " poulet", " purée", " radis", " restaurant", " sole", " déjeuner", " animal domestique", " animal", " bébé|bébés", " bouche", " cage", " câlin", " caresse", " cochon d’Inde", " foin", " graine|graines", " hamster", " lapin", " maison", " nez", " œil", " oreille", " patte", " toit", " yeux", " accoucher", " agacer", " appeler", " câliner", " caresser", " changer", " déranger", " échapper|s’échapper", " élever", " enfermer", " enterrer", " gratter", " grignoter", " installer", " lâcher", " mordre", " mourir", " naître", " nourrir", " occuper|s’occuper de", " promener|se promener", " ronger", " sauver|se sauver", " soigner", " téter", " vivre", " voir", " abandonné", " enceinte", " maigre", " mort", " né", " vivant", " ferme", " légume", " abeille", " agneau", " aile", " âne", " arbre", " bain", " barque", " bassin", " bébé", " bec", " bête", " bœuf", " botte de foin", " boue", " bouquet", " bourgeon", " branche", " caillou", " campagne", " car", " champ", " chariot", " chat", " cheminée", " cheval", " chèvre", " chien", " cochon", " colline", " coq", " coquelicot", " crapaud", " cygne", " départ", " dindon", " escargot", " étang", " ferme", " fermier", " feuille", " flamme", " fleur", " fontaine", " fumée", " grain", " graine", " grenouille", " griffe", " guêpe", " herbe", " hérisson", " insecte", " jardin", " mare", " marguerite", " miel", " morceau de pain", " mouche", " mouton", " oie", " oiseau", " pierre", " pigeon", " plante", " plume", " poney", " poule", " poussin", " prairie", " rat", " rivière", " route", " tortue", " tracteur", " tulipe", " vache", " vétérinaire", " accompagner", " baigner|se baigner", " courir après", " couver", " donner à manger", " faire boire", " fumer", " griffer", " habiter", " piquer", " ramasser", " traire", " bizarre", " énorme", " immense", " malade", " nain", " utile", " zoo", " aigle", " animal|animaux", " aquarium", " bête|bêtes", " cerf", " chouette", " cigogne", " crocodile", " dauphin", " éléphant", " girafe", " hibou", " hippopotame", " kangourou", " lion", " loup", " ours", " panda", " panthère", " perroquet", " phoque", " renard", " requin", " rhinocéros", " singe", " tigre", " zèbre", " zoo", " carnaval", " épingle", " bâton", " bêtise", " bonhomme", " botte|bottes", " canne", " cauchemar", " cri", " danse", " déguisement", " dinosaure", " drapeau", " en argent", " en or", " en rang", " fête", " figure", " géant", " gens", " grand-mère", " grand-père", " joie", " joue", " journal|journaux", " maquillage", " masque", " monsieur", " moustache", " ogre", " princesse", " rue", " trottoir", " déguiser", " défiler", " éclater", " essayer", " marcher", " moquer|se moquer", " plaire", " rencontrer", " ressembler|ressembler à", " retourner", " rêver", " rire", " taper|taper sur", " danser", " sauter", " chanter", " content", " drôle", " effrayé", " heureux", " joyeux", " prêt", " riche", " terrible", " fête", " école", " Noël", " boule", " cadeau", " canne à pêche", " chance", " cube", " guirlande", " humeur", " papillon", " spectacle", " surprise", " trou", " visage", " faire peur", " lever", " maquiller", " électrique", " heure", " calendrier", " âge", " an", " année", " après-midi", " calendrier", " début", " dimanche", " été", " étoile", " fin", " heure des mamans", " heure", " hiver", " horloge", " jeudi", " jour", " journée", " lumière", " lundi", " lune", " mardi", " matin", " mercredi", " midi", " minuit", " minute", " mois", " moment", " montre", " nuit", " ombre", " pendule", " retour", " réveil", " saison", " samedi", " semaine", " soir", " soleil", " temps", " univers", " vacance|vacances", " vendredi", " avancer", " briller", " dîner", " grandir", " mettre|mettre du temps", " suivre", " chronologie", " retarder", " aîné", " jeune", " lent", " patient", " rapide", " sombre", " vieux", " aujourd’hui", " bientôt", " d’abord", " demain", " hier", " maintenant", " puis", " tout de suite", " en avance", " en retard", " météo", " air", " arc-en-ciel", " brouillard", " ciel", " éclair", " flocon", " goutte", " hirondelle", " luge", " neige", " nuage", " orage", " ouragan", " parapluie", " parasol", " ski", " tempête", " thermomètre", " tonnerre", " traîneau", " vent", " abriter|s’abriter", " faire beau", " geler", " mouiller|se mouiller", " neiger", " tromper|se tromper", " pleuvoir", " venter", " déçu", " triste", " chaud", " froid", " pluvieux", " nuageux", " humide", " gelé", " instable", " changeant"};
    ArrayList<String> movies ;
    String[] moviesSave = { "Avengers", "Avatar", "Star Wars", "Jurassic Parc", "Le Roi lion", "Fast and Furious", "La Reine des neiges", "Harry Potter", "La Belle et la Bête", "Les Indestructibles", "Iron Man", "Spider-Man", "Transformers", "Batman : The Dark Knight", "Joker", "Toy Story", "Pirate des Caraibes", "Moi moche et méchant", "Le monde de Némo", "Alice au pays des merveilles", "Le seigneur des anneaux", "Le Livre de la jungle", "E.T. L'extraterrestre", "Le Parrain", "L'Exorciste", "Rocky", "Indiana Jones", "Retour vers le futur", "Aladdin", "Intouchables", "Taken", "Bienvenue chez les Ch'tis", "Qu'est-ce qu'on a fait au Bon Dieu", "James Bond", "Shrek", "Twilight", "Hunger Games"};
    private static DataSingleton instance = null;

    private DataSingleton(){
    }

    public ArrayList<String> getMovies() {
        Collections.sort(movies);
        return movies;
    }

    public String getRandomWord(){
        Random r = new Random();
        int lim = word.length;
        String next = word[r.nextInt(lim)];
        if(next.contains("|"))
            next = next.split("\\|")[0];
        return next;
    }

    public static DataSingleton getInstance() {
        if(instance == null){
            instance = new DataSingleton();
        }
        return instance;
    }

    public int getNumberWord(){
        return word.length;
    }

    public ArrayList<String> getMovies(int nb){
        ArrayList<String> next = new ArrayList<>();
        ArrayList<String> actual = new ArrayList<String>(movies);
        for(int i = 0; i < nb; i ++){
            Random r = new Random();
            int lim = actual.size();
            int pos =  r.nextInt(lim);
            String toadd = actual.get(pos);
            actual.remove(pos);
            next.add(toadd);
        }
        return next;
    }

    public int getMoviesSize(){
        return movies.size();
    }

    public void writeMovies(Context context){
        SharedPreferences test = context.getSharedPreferences("Movie", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = test.edit();
        editor.putStringSet("movies", new HashSet<String>(movies));
        editor.commit();
    }

    public void readMovies(Context context){
        SharedPreferences test = context.getSharedPreferences("Movie", Context.MODE_PRIVATE);
        movies = new ArrayList<>(test.getStringSet("movies", new HashSet<String>(Arrays.asList(moviesSave))));
    }

    public void addMovie(Context context, String next){
        movies.add(next);
        writeMovies(context);
    }

    public void deleteMovie(Context context, String string){
        int next = -1;
        for(String s : movies){
            if (s.equals(string))
                next = movies.indexOf(s);
        }
        if(next != -1)
            movies.remove(next);
        writeMovies(context);
    }
}
