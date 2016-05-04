package by.tut.tiomkin.class12;

import android.graphics.Typeface;
import android.util.Log;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Typefaces
 *
 * @author Timofey Kovalenko
 */
public class TTypefaces {

    private static final String TAG = TTypefaces.class.getSimpleName();

    public static final int Monda_Bold = 0;
    public static final int Monda_Regular = 1;

    private static class FontHashMap extends HashMap<Integer, String> {
        private static final long serialVersionUID = 1L;

        {
            // fonts
            put(Monda_Bold, "Monda-Bold.ttf");
            put(Monda_Regular, "Monda-Regular.ttf");
        }
    }

    private static final HashMap<Integer, String> fontHashMap = new FontHashMap();

    private static final Hashtable<String, Typeface> cache = new Hashtable<>();

    public static Typeface get(android.content.Context c, String assetPath) {
        synchronized (cache) {
            if (!cache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(),
                            assetPath);
                    cache.put(assetPath, t);
                } catch (Exception e) {
                    Log.w(TAG, "Could not get typeface" + assetPath, e);
                    return null;
                }
            }
            return cache.get(assetPath);
        }
    }

    public static Typeface get(android.content.Context c, int fontEnum) {

        String name = fontHashMap.get(fontEnum);

        if (name == null) {
            throw new IllegalArgumentException("Could not get typeface");
        }

        return get(c, "fonts/" + name);
    }
}

