package io.poly.tomlib.samples;

import io.poly.tomlib.logo.LogoPrinter;

/// A simple sample demonstrating how to use the LogoPrinter.
public class LogoSample {

    /// Main entry point for the sample.
    public static void main(String[] args) {
        System.out.println("Starting Logo Sample...");

        LogoPrinter printer = LogoPrinter.instance();

        // Print a normal logo
        System.out.println("\n--- Standard Logo ---");
        printer.printLogo(false);

        // Print a glitchy logo
        System.out.println("\n--- Glitchy Logo ---");
        printer.printLogo(true);
    }
}
