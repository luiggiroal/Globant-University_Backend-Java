package entidades;

public class Comentario {
    private int idComentario;
    private int idCasa;
    private String comentario;

    public Comentario(int idComentario, int idCasa, String comentario) {
        this.idComentario = idComentario;
        this.idCasa = idCasa;
        this.comentario = comentario;
    }

    public Comentario(int idCasa, String comentario) {
        this.idCasa = idCasa;
        this.comentario = comentario;
    }

    public Comentario() {
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "idComentario=" + idComentario +
                ", idCasa=" + idCasa +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
