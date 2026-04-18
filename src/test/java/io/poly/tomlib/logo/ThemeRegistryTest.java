package io.poly.tomlib.logo;

import io.poly.tomlib.logo.theme.standard.StandardLogoTheme;
import io.poly.tomlib.logo.theme.festive.FestiveTheme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class ThemeRegistryTest {

    @BeforeEach
    public void setUp() {
        ThemeRegistry.clearCache();
    }

    @Test
    public void dynamicDiscovery() {
        Map<Class<? extends Theme>, Theme> themes = ThemeRegistry.getThemes();
        assertFalse(themes.isEmpty(), "ThemeRegistry should discover themes via ServiceLoader");
        assertTrue(themes.containsKey(StandardLogoTheme.class), "StandardLogoTheme should be discovered");
        assertTrue(themes.containsKey(FestiveTheme.class), "FestiveTheme should be discovered");
    }

    @Test
    public void caching() {
        Theme theme1 = ThemeRegistry.getTheme(StandardLogoTheme.class).get();
        Theme theme2 = ThemeRegistry.getTheme(StandardLogoTheme.class).get();
        assertSame(theme1, theme2, "ThemeRegistry should cache theme instances");
    }

    @Test
    public void getThemeByType() {
        StandardLogoTheme standard = ThemeRegistry.getTheme(StandardLogoTheme.class).get();
        assertNotNull(standard, "Should be able to get StandardLogoTheme");
    }
}
