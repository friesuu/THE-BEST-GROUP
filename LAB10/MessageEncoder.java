package LAB10;

public interface MessageEncoder 
{
    public String encode(String inputStr, int shiftKey);
    public String decode(String inputStr, int shiftKey);
}
