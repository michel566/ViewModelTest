package michel566.androidmodules.saveinstancestatetest;

import android.app.Application;
import android.content.res.Configuration;

import org.jetbrains.annotations.NotNull;

public class App extends Application {

    public static boolean isOrientationChanged = false;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ||
                newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            isOrientationChanged = true;
        }
    }

}
