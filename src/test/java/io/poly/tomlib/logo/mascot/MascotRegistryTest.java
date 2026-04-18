package io.poly.tomlib.logo.mascot;

import io.poly.tomlib.logo.AbstractMascot;
import io.poly.tomlib.logo.MascotRegistry;
import io.poly.tomlib.logo.theme.festive.mascot.SnowmanMascot;
import io.poly.tomlib.logo.theme.standard.mascot.CatMascot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class MascotRegistryTest {

    @BeforeEach
    public void setUp() {
        MascotRegistry.clearCache();
    }

    @Test
    public void dynamicDiscovery() {
        Map<Class<? extends AbstractMascot>, AbstractMascot> mascots = MascotRegistry.getMascots();
        assertFalse(mascots.isEmpty(), "MascotRegistry should discover mascots via ServiceLoader");
        assertTrue(mascots.containsKey(SnowmanMascot.class), "SnowmanMascot should be discovered");
        assertTrue(mascots.containsKey(CatMascot.class), "CatMascot should be discovered");
    }

    @Test
    public void caching() {
        AbstractMascot mascot1 = MascotRegistry.getMascot(SnowmanMascot.class);
        AbstractMascot mascot2 = MascotRegistry.getMascot(SnowmanMascot.class);
        assertSame(mascot1, mascot2, "MascotRegistry should cache mascot instances");
    }

    @Test
    public void getMascotByType() {
        SnowmanMascot snowman = MascotRegistry.getMascot(SnowmanMascot.class);
        assertNotNull(snowman, "Should be able to get SnowmanMascot");
        assertTrue(snowman instanceof SnowmanMascot);
    }
}
