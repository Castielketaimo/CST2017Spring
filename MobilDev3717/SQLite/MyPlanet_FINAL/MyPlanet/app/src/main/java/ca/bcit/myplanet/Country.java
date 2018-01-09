package ca.bcit.myplanet;

/**
 * Created by A00127241 on 2017-09-29.
 */

public class Country {
    private String _continent;
    private String _description;
    private String _name;
    private int _imageResourceId;

    public static final Country[] northAmericaCountries = {
            new Country("North America", "Canada", "Canada is a country in the northern part of North America. Its ten provinces and three territories extend from the Atlantic to the Pacific and northward into the Arctic Ocean, covering 9.98 million square kilometres (3.85 million square miles), making it the world's second-largest country by total area and the fourth-largest country by land area. Canada's southern border with the United States is the world's longest bi-national land border. The majority of the country has a cold or severely cold winter climate, but southerly areas are warm in summer. Canada is sparsely populated, the majority of its land territory being dominated by forest and tundra and the Rocky Mountains. It is highly urbanized with 82 per cent of the 35.15 million people concentrated in large and medium-sized cities, many near the southern border. Its capital is Ottawa, and its largest metropolitan areas are Toronto, Montreal and Vancouver.", R.drawable.canada),
            new Country("North America", "USA", "The United States of America (USA), commonly known as the United States (U.S.) or America is a federal republic composed of 50 states, a federal district, five major self-governing territories, and various possessions. Forty-eight states and the federal district are contiguous and located in North America between Canada and Mexico. The state of Alaska is in the northwest corner of North America, bordered by Canada to the east and across the Bering Strait from Russia to the west. The state of Hawaii is an archipelago in the mid-Pacific Ocean. The U.S. territories are scattered about the Pacific Ocean and the Caribbean Sea, stretching across nine official time zones. The extremely diverse geography, climate and wildlife of the United States make it one of the world's 17 megadiverse countries.", R.drawable.usa),
            new Country("North America", "Mexico", "Mexico , officially the United Mexican States (Spanish: Estados Unidos Mexicanos,  listen (help·info)), is a federal republic in the southern portion of North America. It is bordered to the north by the United States; to the south and west by the Pacific Ocean; to the southeast by Guatemala, Belize, and the Caribbean Sea; and to the east by the Gulf of Mexico. Covering almost two million square kilometers (over 760,000 sq mi),Mexico is the sixth largest country in the Americas by total area and the 13th largest independent nation in the world.\n" +
                    "With an estimated population of over 120 million, Mexico is the eleventh most populous country and the most populous Spanish-speaking country in the world while being the second most populous country in Latin America. Mexico is a federation comprising 31 states and a special federal entity that is also its capital and most populous city. Other metropolises include Guadalajara, León, Monterrey, Puebla, Toluca, and Tijuana.", R.drawable.mexico),
    };

    // Each country has a name, description and an image resource
    public Country(String continent, String name, String description, int imageResourceId) {
        _continent = continent;
        _name = name;
        _description = description;
        _imageResourceId = imageResourceId;
    }

    public String getName() {
        return _name;
    }

    public String getContinent() {
        return _continent;
    }

    public String getDescription() {
        return _description;
    }

    public int getImageResourceId() {
        return _imageResourceId;
    }

    public String toString() {
        return _name;
    }
}
