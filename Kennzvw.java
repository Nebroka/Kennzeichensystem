/**
 * <p>
 * Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule,
 * Materialien zum schulinternen Lehrplan Informatik SII
 * </p>
 *
 * @version 2014-03-13
 */
public class Kennzvw {
    private BinarySearchTree<Kennzeichen> baum;

    public Kennzvw() {
        baum = new BinarySearchTree<Kennzeichen>();
    }

    public void ergaenze(String pBezeichn, String pOrtskennz) {
        Kennzeichen kennz = new Kennzeichen(pBezeichn, pOrtskennz);
        baum.insert(kennz);
    }

    public void loesche(String pBezeichn, String pOrtskennz) {
        Kennzeichen kennz = new Kennzeichen(pBezeichn, pOrtskennz);
        if (!baum.isEmpty()) {
            baum.remove(kennz);
        }
    }

    public BinaryTree<Kennzeichen> gibBaum() {
        return gibBaum(baum);
    }

    private BinaryTree<Kennzeichen> gibBaum(BinarySearchTree<Kennzeichen> bs) {
        BinaryTree<Kennzeichen> b;
        if (bs.isEmpty())
            b = new BinaryTree<Kennzeichen>();
        else {
            b = new BinaryTree<Kennzeichen>(bs.getContent());
            if (bs.getLeftTree() != null)
                b.setLeftTree(this.gibBaum(bs.getLeftTree()));
            if (bs.getRightTree() != null)
                b.setRightTree(this.gibBaum(bs.getRightTree()));
        }
        return b;
    }

    public void leereBaum() {
        baum = new BinarySearchTree<Kennzeichen>();
    }

    public String toString() {
        return inorder(baum);
    }

    public String inorder(BinarySearchTree<Kennzeichen> b) {
        String links = "";
        String mitte = "";
        String rechts = "";
        if (!b.isEmpty()) {
            links = inorder(b.getLeftTree());
            mitte = b.getContent().toString() + "\n";
            rechts = inorder(b.getRightTree());
        }
        return links + mitte + rechts;
    }

}
