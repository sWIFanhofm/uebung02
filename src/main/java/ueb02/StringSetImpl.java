package ueb02;

import java.util.NoSuchElementException;

public class StringSetImpl implements StringSet {

    class Element{
        String value;
        Element left, right;

        public Element(String v, Element l, Element r){
            value = v;
            left = l;
            right = r;
        }

        public int size(){
            return 1 + (left == null ? 0 : left.size())
                    + (right == null ? 0 : right.size());
        }

        public String toString(){
            return value + (left == null ? "" : ", "  + left)
                    + (right == null ? "" : ", " + right);
        }
    }

    Element root;

    @Override
    public boolean add(String s) {
        return addElement(new Element(s, null, null));
    }

    public boolean addElement(Element e){
        if(e == null)
            return false;

        if(root == null){
            root = e;
            return true;
        }

        Element it = root;
        while(it != null){
            int c = e.value.compareTo(it.value);
            if(c == 0)
                return false;
            else if(c < 0){
                if(it.left == null){
                    it.left = e;
                    return true;
                } else
                    it = it.left;
            } else {
                if(it.right == null){
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
        if(root == null)
            return false;

        Element it = root;
        while(it != null){
            int c = s.compareTo(it.value);
            if(c == 0)
                return true;
            else if(c < 0){
                it = it.left;
            } else {
                it = it.right;
            }
        }
        return false;
    }

    @Override
    public String remove(String s) {
        if(root == null)
            throw new NoSuchElementException();

        if(root.value.equals(s))
            return removeRoot();

        Element it = root;
        while(it != null){
            int c = s.compareTo(it.value);
            if(c < 0) {
                    if (it.left != null && it.left.value.equals(s))
                        return removeElement(it, it.left);
                    it = it.left;
            } else{
                    if(it.right != null && it.right.value.equals(s))
                        return removeElement(it, it.right);
                    it = it.right;

                }
            }
        throw new NoSuchElementException();
    }

    private String removeRoot(){
        assert(root != null);

        Element e = root;
        if(e.left == null && e.right == null){
            root = null;
        } else if(e.left == null){
            root = e.right;
        } else if(e.right == null){
            root = e.left;
        } else{
            root = e.left;
            addElement(e.right);
        }
        return e.value;
    }

    private String removeElement(Element p, Element e){
        //p = Elternelement, e = zu löschendes Element
        if(e == p.left){
            p.left = null;
        } else{
            p.right = null;
        }

        //Eventuelle Teilbäume neu in den Baum einfügen
        addElement(e.left);
        addElement(e.right);

        return e.value;
    }

    @Override
    public int size() {
        if(root == null) {
            return 0;
        } else
            return root.size();
    }

    public String toString(){
        if(root == null) {
            return "[]";
        } else {
            return "[ " + root.toString() + " ]";
        }

    }
}
