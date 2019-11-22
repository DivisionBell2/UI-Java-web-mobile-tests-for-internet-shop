package testData;

public enum Categories {

    //PRODUCT CATEGORIES
    BRANDS("Бренды"),
    CLOTHES("Одежда"),
    BAGS("Сумки"),
    SHOES("Обувь"),
    ACCESSORIES("Аксессуары"),
    SALE("Sale"),

    BRAND_CATEGORY("По категориям"),
    SALE_CATEGORY("Sale в категории"),
    ALL_CATEGORIES("Все категории"),
    CATEGORIES("Категории"),

    //USER MENU LIST
    QUESTION("Задать вопрос"),
    PERSONAL_DATA("Персональные данные"),
    MY_ORDERS("Мои заказы"),
    CLUB_CARD("Клубная карта");

    private String category;

    Categories(String category) {
        this.category = category;
    }

    public String getValue() {
        return category;
    }
}
