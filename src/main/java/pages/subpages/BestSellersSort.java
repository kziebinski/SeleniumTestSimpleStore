package pages.subpages;

public enum BestSellersSort{

    PRICE_DESC("price:desc"),
    PRICE_ASC("price:asc"),
    NAME_ASC("name:asc");

    private String sort;

    BestSellersSort(String sort) {
        this.sort = sort;
    }

    public String getNameSort(){
        return sort;
    }
}