/**
 * <p>
 * Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule,
 * Materialien zum schulinternen Lehrplan Informatik SII
 * </p>
 *
 * @version 2014-03-13
 */
public class Kennzeichen implements ComparableContent<Kennzeichen> {
    private String bezeichn;
    private String ortskennz;

    public Kennzeichen(String pBezeichn, String pOrtskennz) {
        super();
        bezeichn = pBezeichn;
        ortskennz = pOrtskennz;
    }

    public String gibBezeichnung() {
        return bezeichn;
    }

    public String gibOrtskz() {
        return ortskennz;
    }

    public boolean isLess(Kennzeichen pContent) {
        return this.gibOrtskz().compareTo(pContent.gibOrtskz()) < 0;
    }

    public boolean isEqual(Kennzeichen pContent) {
        return this.gibOrtskz().compareTo(pContent.gibOrtskz()) == 0;
    }

    public boolean isGreater(Kennzeichen pContent) {
        return this.gibOrtskz().compareTo(pContent.gibOrtskz()) > 0;
    }

    public String toString() {
        return ortskennz + " " + bezeichn;
    }

}
