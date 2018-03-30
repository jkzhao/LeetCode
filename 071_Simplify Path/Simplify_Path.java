
import java.util.*;

/**
 * Created by jkzhao on 3/29/18.
 */
public class Simplify_Path {
    /**
     * Given an absolute path for a file (Unix-style), simplify it.
     For example,
     path = "/home/", => "/home"
     path = "/a/./b/../../c/", => "/c"

     Corner Cases:
        Did you consider the case where path = "/../"?
        In this case, you should return "/".
        Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
        In this case, you should ignore redundant slashes and return "/home/foo".
     */

    public static String simplifyPath(String path) {
        String res = "";
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", ".", ""));

        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.empty()) stack.pop();
            else if (!set.contains(dir)) stack.push(dir);
        }

        //for (String dir : stack) //这种方式拿出来的顺序是从栈底出来
        //res = "/" + dir + res;
        while (!stack.empty()) {
            res = "/" + stack.pop() + res;
        }

        return res.isEmpty() ? "/" : res;

    }

    public static String simplifyPath2(String path) {
        String res = "";
        //Stack<String> stack = new Stack<>();
        Deque<String> stack = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", ".", ""));

        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!set.contains(dir)) stack.push(dir);
        }

        //for (String dir : stack) //这样用也可以
            //res = "/" + dir + res;
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }

        return res.isEmpty() ? "/" : res;

    }

    public static void main(String[] args) {
        //String path = "/a/./b/../../c/";
        //String path = "/";
        String path = "/abc/...";
        String simplePath = Simplify_Path.simplifyPath2(path);
        System.out.println(simplePath);
    }

}
