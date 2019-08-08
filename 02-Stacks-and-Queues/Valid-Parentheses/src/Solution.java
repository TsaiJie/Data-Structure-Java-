
class Solution {
    public boolean isValid(String s) {

        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++){
             char c = s.charAt(i);
//             如果是左边的括弧 全部入栈
             if(c == '(' || c == '[' || c == '{'){
                 stack.push(c);
             }else {
//                查看栈是否为空
                 if(stack.isEmpty()){
                     return false;
                 }
                 //如果为右括弧，那么拿当前的c括弧和栈顶元素作比较，看是否能匹配成功
                 char topChar = stack.pop();
                 if(c == ')' && topChar !='(')
                     return false;
                 if(c == ']' && topChar !='[')
                     return false;
                 if(c == '}' && topChar !='{')
                     return false;
             }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution()).isValid("([)]"));

    }
}