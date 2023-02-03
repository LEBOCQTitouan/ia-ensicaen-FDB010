package fr.ensicaen.lv223.model;

/**
 * The {@code CellType} enumeration represents the different types of cells
 * that can exist in the 2D grid of LV-223.
 */
public enum CellType {
    BASE,      /**<! A cell that contains the base of the colony (part of the
     exoskeleton). */
    BOUNDARY,  /**<! NOT YET USED */
    DESERT,    /**<! A cell that contains a desert. */
    DRY_GRASS, /**<! A cell that contains a dry meadow. */
    FOOD,      /**<! A cell that contains a some food. */
    FOREST,    /**<! A cell that contains a forest. */
    GRASS,     /**<! A cell that contains a meadow. */
    IMPENETRABLE, /**<! A cell that is impenetrable (part of the exoskeleton). */
    LAKE,      /**<! A cell that contains a lake (part of the exoskeleton). */
    ORE,       /**<! A cell that contains mineral deposits (part of the
     exoskeleton). */
    STONE,     /**<! A cell that contains stones (part of the exoskeleton). */
    WET_GRASS  /**<! A cell that contains a wet meadow. */
}
