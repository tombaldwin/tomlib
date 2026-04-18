package io.poly.tomlib.util;

///
/// Centralised configuration for the tomlib library.
/// Provides control over privacy-sensitive features such as user inference
/// and security-sensitive features such as network access.
///
public final class TomlibConfig {

    private TomlibConfig() {
        // Utility class
    }

    ///
    /// Determines if user information inference is enabled.
    /// Default is true, unless the 'tomlib.inference.enabled' system property
    /// or 'TOMLIB_INFERENCE_ENABLED' environment variable is set to 'false'.
    ///
    /// @return true if inference is permitted, false otherwise
    ///
    public static boolean isInferenceEnabled() {
        String sysProp = System.getProperty("tomlib.inference.enabled");
        if (sysProp != null) {
            return Boolean.parseBoolean(sysProp);
        }
        String envVar = System.getenv("TOMLIB_INFERENCE_ENABLED");
        if (envVar != null) {
            return Boolean.parseBoolean(envVar);
        }
        return true;
    }

    ///
    /// Determines if external network access is enabled.
    /// Default is true, unless the 'tomlib.network.enabled' system property
    /// or 'TOMLIB_NETWORK_ENABLED' environment variable is set to 'false'.
    ///
    /// @return true if network access is permitted, false otherwise
    ///
    public static boolean isNetworkEnabled() {
        String sysProp = System.getProperty("tomlib.network.enabled");
        if (sysProp != null) {
            return Boolean.parseBoolean(sysProp);
        }
        String envVar = System.getenv("TOMLIB_NETWORK_ENABLED");
        if (envVar != null) {
            return Boolean.parseBoolean(envVar);
        }
        return true;
    }
}
