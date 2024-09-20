import java.util.ArrayList;
import java.util.Scanner;

class Video {
    private String titulo;
    private String autor;
    private String url;
    private boolean activo;
    
    public Video(String titulo, String autor, String url, boolean activo) {
        this.titulo = titulo;
        this.autor = autor;
        this.url = url;
        this.activo = activo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getUrl() {
        return url;
    }

    public boolean isActivo() {
        return activo;
    }
    
    public String toString() {
        return "Video{" +
                "Titulo='" + titulo + '\'' +
                ", Autor='" + autor + '\'' +
                ", URL='" + url + '\'' +
                ", Activo=" + activo +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Video> listaVideos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese el título del video: ");
            String titulo = scanner.nextLine();

            System.out.println("Ingrese el autor del video: ");
            String autor = scanner.nextLine();

            System.out.println("Ingrese la URL del video: ");
            String url = scanner.nextLine();

            System.out.println("¿El video está activo? (Si/No): ");
            boolean activo = Boolean.parseBoolean(scanner.nextLine());

            
            Video video = new Video(titulo, autor, url, activo);
            listaVideos.add(video);

            System.out.println("\n¿Desea agregar otro video? (Si/No): ");
            String continuar = scanner.nextLine();
            if (continuar.equalsIgnoreCase("No")) {
                break;
            }
        }

        System.out.println("\nLista de videos ingresados:");
        for (Video video : listaVideos) {
            System.out.println(video);
        }
    }
}