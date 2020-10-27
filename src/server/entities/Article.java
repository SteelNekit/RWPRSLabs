package server.entities;

public class Article {
    private String title;
    private float cost;
    private String description;

    public Article(String title, float cost, String description){
        this.title = title;
        this.cost = cost;
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(title).append('|');
        sb.append(' ').append(cost).append('\n');
        sb.append("Описание: \n").append(description);
        sb.append('\n');
        return sb.toString();
    }
}
