package sanctuary.capability.spirit;

import net.minecraft.entity.Entity;

/**
 *  Spirit handler to store multiple spirit types.
 */
public class SpiritHandler implements ISpiritHandler {
    private final int[] m_stored = new int[Spirit.SPIRITS_COUNT];
    private final int[] m_capacity = new int[Spirit.SPIRITS_COUNT];

    public SpiritHandler() {
    }

    public void setCapacity(int[] capacity){
        if(capacity.length != Spirit.SPIRITS_COUNT ){
            throw new IllegalArgumentException("Length of capacity array needs to match SPIRITS_COUNT");
        }

        for (int i = 0; i < Spirit.SPIRITS_COUNT; i++) {
            m_capacity[i] = capacity[i];
            m_stored[i] = Math.min(m_stored[i], m_capacity[i]);
        }
    }

    public void setStored(int[] amount){
        if(amount.length != Spirit.SPIRITS_COUNT ){
            throw new IllegalArgumentException("Length of capacity array needs to match SPIRITS_COUNT");
        }

        for (int i = 0; i < Spirit.SPIRITS_COUNT; i++) {
            m_stored[i] = Math.min(amount[i], m_capacity[i]);
        }
    }

    @Override
    public int pull(Spirit type, int amount) {
        if(amount < 0) return 0;

        final int stored = m_stored[type.ordinal()];

        if(stored < amount){
            amount = stored;
        }

        m_stored[type.ordinal()] = stored - amount;
        return amount;
    }

    @Override
    public int push(Spirit type, int amount) {
        if(amount < 0) return 0;

        final int diff = m_capacity[type.ordinal()] - m_stored[type.ordinal()];

        if(diff < amount){
            amount = diff;
        }

        m_stored[type.ordinal()] -= amount;
        return amount;
    }

    @Override
    public boolean canPull(Spirit type, int amount) {
        return amount > 0 && amount <= m_stored[type.ordinal()];
    }

    @Override
    public boolean canPush(Spirit type, int amount) {
        return amount > 0 && amount <= (m_capacity[type.ordinal()] - m_stored[type.ordinal()]);
    }

    @Override
    public int getStored(Spirit type) {
        return m_stored[type.ordinal()];
    }

    @Override
    public int getMaxStored(Spirit type) {
        return 0;
    }

    @Override
    public int[] getStored() {
        return m_stored;
    }
}
