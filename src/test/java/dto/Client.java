package dto;

public class Client {
    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
    }

    public void setFirm_town(String firm_town) {
        this.firm_town = firm_town;
    }

    public void setFirm_addr(String firm_addr) {
        this.firm_addr = firm_addr;
    }

    public void setFirm_is_reg_vat(boolean firm_is_reg_vat) {
        this.firm_is_reg_vat = firm_is_reg_vat;
    }

    public void setFirm_mol(String firm_mol) {
        this.firm_mol = firm_mol;
    }

    private String firm_name;
    private String firm_town;
    private String firm_addr;
    private boolean firm_is_reg_vat;
    private String firm_mol;

}
