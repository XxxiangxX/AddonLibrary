package blocksp.util.Misc;

public class ValueAlreadyExistException extends RuntimeException{
    static final long serialVersionUID = 9162710183389043792L;
    public ValueAlreadyExistException(){}
    public ValueAlreadyExistException(String var){
        super(var);
    }
}
