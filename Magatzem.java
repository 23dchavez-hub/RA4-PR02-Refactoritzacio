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
        // El bucle ara només crida a una funció per a cada article
        for (int i = 0; i < articles.length; i++) {
            processarArticle(articles[i]);
        }
    }

    private void processarArticle(Article article) {
        // En el següent pas posarem el contingut aquí dins
    }
}
