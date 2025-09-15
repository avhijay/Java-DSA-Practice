public class StringOperations {

    public  static String reverse(String input){
        char [] inputs =input.toCharArray();
        int a = 0;
        int b = inputs.length-1;

        while(a<=b){
            char temp= inputs[a];
            inputs[a]=inputs[b];
            inputs[b]=temp;
            a++;
            b--;
        }
        return new String(inputs);

    }











public  static  void main (String[]args){
        String input = "my Name is Name";
    System.out.println(input);
    System.out.println(reverse(input));
}
}
