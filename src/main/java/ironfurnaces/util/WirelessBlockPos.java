package ironfurnaces.util;

import java.util.Objects;

public class WirelessBlockPos {

    private final int posX;
    private final int posY;
    private final int posZ;
    // Can be mutable, but care needs to be taken when using

    public WirelessBlockPos(int posX, int posY, int posZ) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.posX, this.posY, this.posZ);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return obj instanceof WirelessBlockPos ex
                    && this.posX == ex.posX
                    && this.posY == ex.posY
                    && this.posZ == ex.posZ;
        }
    }
}