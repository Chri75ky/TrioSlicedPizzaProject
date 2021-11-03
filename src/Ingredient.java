public class Ingredient {
    private String name;
    Type type;

    enum Type {
        KØD(12),
        GRØNT(7),
        DRESSING(5),
        ANDET(0);

        private final int pris;


        Type(int pris) {
            this.pris = pris;
        }

        @Override
        public String toString() {
            return  pris +
                    ",-";
        }
    }

    public Ingredient(String name, Type type) {
        this.name = name;
        this.type = type;
    }


    public String toStrings() {
        return "Ekstra " + name + " koster " + type.pris + ",-";
    }
}

