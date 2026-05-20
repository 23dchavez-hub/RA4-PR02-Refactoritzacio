class Article {
    public String nom;
    public int diesPerVendre;
    public int qualitat;

    public Article(String nom, int diesPerVendre, int qualitat) {
        this.nom = nom;
        this.diesPerVendre = diesPerVendre;
        this.qualitat = qualitat;
    }
}

class Magatzem {
    Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (int i = 0; i < articles.length; i++) {
            processarArticle(articles[i]);
        }
    }

    private void processarArticle(Article article) {
        // REGLE 1: Martell de Thor (Llegendari) - No canvia mai de cap manera
        if (article.nom.equals("Martell de Thor (Llegendari)")) {
            return; 
        }

        // REGLE 2: Formatge Gidurat - Millora la qualitat amb els dies (límit 50)
        if (article.nom.equals("Formatge Gidurat")) {
            article.diesPerVendre--; 
            if (article.qualitat < 50) {
                article.qualitat++; 
            }
            if (article.diesPerVendre < 0 && article.qualitat < 50) {
                article.qualitat++; // Puja el doble si ha caducat
            }
            return; 
        }

        // REGLE 3: Entrades per al Concert - Pujen de qualitat segons els dies. Caducades valen 0
        if (article.nom.equals("Entrades per al Concert del Trobador")) {
            article.diesPerVendre--; 
            if (article.diesPerVendre < 0) {
                article.qualitat = 0; 
            } else {
                if (article.qualitat < 50) article.qualitat++; 
                if (article.diesPerVendre < 10 && article.qualitat < 50) article.qualitat++; 
                if (article.diesPerVendre < 5 && article.qualitat < 50) article.qualitat++;  
            }
            return; 
        }

        // REGLE 4: Articles Normals - Baixen qualitat de 1 en 1, i el doble si han caducat (mínim 0)
        article.diesPerVendre--; 
        if (article.qualitat > 0) {
            article.qualitat--; 
        }
        if (article.diesPerVendre < 0 && article.qualitat > 0) {
            article.qualitat--; 
        }
    }
}
