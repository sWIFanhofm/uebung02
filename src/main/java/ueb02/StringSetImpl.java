package ueb02;

import java.util.NoSuchElementException;

public class StringSetImpl implements StringSet {

    class Element {
        String val;
        Element left;
        Element right;

        Element(String v, Element l, Element r) {
            val = v;
            left = l;
            right = r;
        }

        int size(){
            int s = 1;

            if(left != null)
                s += left.size();

            if(right != null)
                s += right.size();

            return s;
        }
    }

    Element root;


    @Override
    public boolean add(String s) {
        Element e = new Element(s, null, null);

        if (root == null) {
            root = e;
            return true;
        }

        Element it = root;
        while (it != null) {
            if (it.val.equals(s)) {
                return false;
            }
            else if (e.val.compareTo(it.val) < 0) {
                if (it.left == null) {
                    it.left = e;
                    return true;
                } else
                    it = it.left;
            } else {
                if (it.right == null) {
                    it.right = e;
                    return true;
                } else
                    it = it.right;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String s) {
        if (root == null)
            return false;

        Element it = root;
        while (it != null) {
            if (s.equals(it.val))
                return true;
            else if (s.compareTo(it.val) < 0) {
                    it = it.left;
            }
            else
                it = it.right;
        }
        return false;
    }

    @Override
    public String remove(String s) {
        if(root == null)
            throw new NoSuchElementException();

        if(root.val.equals(s){
            return removeRoot();
        }

        Element it = root;

    }

    @Override
    public int size() {
        if(root == null)
            return 0;
        else return root.size();
    }
}
