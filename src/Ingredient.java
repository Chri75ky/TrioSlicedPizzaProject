public class Ingredient {
    /* Klassen ingredient, skulle være brugt som en måde til at
    kunne oprette custom pizzaer hvor en pris ville blive lavet ud fra en kombination af
    de forskellige toppings priser sammensat med en "base cost"
    for selve bunden af pizzaen.
    Der har været flere forsøg på at lave metoden, men indtil
    videre har vi ikke haft succes. Klassen bliver her dog da det passer bedre
    med enkelte ingredienser i stedet for en String og da klassen fungerer som en skal.
     */
    private final String name;
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
            return pris +
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

