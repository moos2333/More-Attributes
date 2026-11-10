package com.npstra.moreattributes;

public final class ResistanceMath {
    private static final double MAX_MULTIPLIER = 1_000_000.0;

    private ResistanceMath() {}

    public static float multiplier(double value) {
        if (value > 1.0) {
            double excess = value - 1.0;
            int n = (int) (excess / 0.5);
            double r = excess - 0.5 * n;
            double pow = Math.pow(0.5, n);
            return (float) Math.max(0.0, pow - r * pow);
        }
        double deficit = 1.0 - value;
        int m = (int) (deficit / 0.5);
        double s = deficit - 0.5 * m;
        double pow = Math.min(Math.pow(1.5, m), MAX_MULTIPLIER);
        return (float) Math.min((1.0 + s) * pow, MAX_MULTIPLIER);
    }
}