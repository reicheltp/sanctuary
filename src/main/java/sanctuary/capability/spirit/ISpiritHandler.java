package sanctuary.capability.spirit;

/**
 *  Spirit handler stores spiritual energy.
 */
public interface ISpiritHandler {

    /**
     * Tries to pull an amount of spiritual energy out of the handler.
     * @param type Spiritual energy type. Eg. Spirit.MOON
     * @param amount Amount of energy to pull. Has to be greater than 0.
     * @return The amount of energy actually pulled. It's between 0 and the requested amount.
     */
    int pull(Spirit type, int amount);


    /**
     * Tries to push an amount of spiritual energy into the handler.
     * @param type Spiritual energy type. Eg. Spirit.MOON
     * @param amount Amount of energy to push. Has to be greater than 0.
     * @return The amount of energy actually pushed. If's less than amount if handler is full.
     */
    int push(Spirit type, int amount);

    /**
     * Returns true if the handler stores at least this amount of spirit.
     * @param type Spiritual energy type. Eg. Spirit.MOON
     * @param amount Amount of energy to pull. Has to be greater than 0.
     * @return True, if the handler stores at least this amount of spirit.
     */
    boolean canPull(Spirit type, int amount);

    /**
     * Returns true if the handler has space for at least this amount of spirit.
     * @param type Spiritual energy type. Eg. Spirit.MOON
     * @param amount Amount of energy to pull. Has to be greater than 0.
     * @return True, if the handler has space for at least this amount of spirit.
     */
    boolean canPush(Spirit type, int amount);

    /**
     * Returns the amount of stored energy.
     * @return Amount of stored energy.
     */
    int[] getStored();

    /**
     * Returns the amount of stored energy for given type.
     * @param type Spiritual energy type. Eg. Spirit.MOON
     * @return Amount of stored energy
     */
    int getStored(Spirit type);

    /**
     * Returns the amount of energy which can be stored.
     * @param type Spiritual energy type. Eg. Spirit.MOON
     * @return Amount of energy which can be stored
     */
    int getMaxStored(Spirit type);

    /**
     * Updates the amount of stored energy. Usually used to sync client and server.
     * For most use cases pull and push is sufficient.
     * @param amount Amount of energy to store.
     */
    void setStored(int[] amount);
}

