package tpiBack.com.tp;

public class EstacionNotFoundException extends RuntimeException {

    public EstacionNotFoundException(Long id) {
        super("No se puede encontrar la estación " + id);
    }
}
