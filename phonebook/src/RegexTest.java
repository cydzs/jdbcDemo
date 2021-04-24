public class RegexTest {
    public static void main(String[] args) {
        String regex = "[0-9]?\\d\\w{2}";
        String content ="5_l";
        System.out.println(content.matches(regex));
    }
}
