/**
 * Клас косметики
 */
public class Cosmetics {
    private String brand;
    private String name;
    private String type;
    private int volumeMl;
    private int priceUAH;

    public Cosmetics(String brand, String name, String type, int volumeMl, int priceUAH) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва бренду не може бути порожньою");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва косметики не може бути порожньою");
        }
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Тип косметики не може бути порожньою");
        }
        if (volumeMl <= 0) {
            throw new IllegalArgumentException("Об'єм не може бути 0 або менше");
        }
        if (priceUAH <= 0) {
            throw new IllegalArgumentException("Ціна не може бути 0 або менше");
        }

        this.brand = brand;
        this.name = name;
        this.type = type;
        this.volumeMl = volumeMl;
        this.priceUAH = priceUAH;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    public int getPriceUAH() {
        return priceUAH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Cosmetics cosmetics = (Cosmetics) o;

        return brand.equals(cosmetics.brand) &&
                name.equals(cosmetics.name) &&
                type.equals(cosmetics.type) &&
                volumeMl == cosmetics.volumeMl &&
                priceUAH == cosmetics.priceUAH;
    }
}