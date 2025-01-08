package api.ramengo.exceptions;

// Pedido inválido
public class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String message) {
        super(message);
    }
}
