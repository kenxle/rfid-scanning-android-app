package com.example.android.sunshine.databinding;
import com.example.android.sunshine.R;
import com.example.android.sunshine.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PrimaryWeatherInfoBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.horizontal_middle, 1);
        sViewsWithIds.put(R.id.date, 2);
        sViewsWithIds.put(R.id.weather_icon, 3);
        sViewsWithIds.put(R.id.weather_description, 4);
        sViewsWithIds.put(R.id.high_temperature, 5);
        sViewsWithIds.put(R.id.low_temperature, 6);
    }
    // views
    @NonNull
    public final android.widget.TextView date;
    @NonNull
    public final android.widget.TextView highTemperature;
    @NonNull
    public final android.support.constraint.Guideline horizontalMiddle;
    @NonNull
    public final android.widget.TextView lowTemperature;
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    public final android.widget.TextView weatherDescription;
    @NonNull
    public final android.widget.ImageView weatherIcon;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PrimaryWeatherInfoBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.date = (android.widget.TextView) bindings[2];
        this.highTemperature = (android.widget.TextView) bindings[5];
        this.horizontalMiddle = (android.support.constraint.Guideline) bindings[1];
        this.lowTemperature = (android.widget.TextView) bindings[6];
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.weatherDescription = (android.widget.TextView) bindings[4];
        this.weatherIcon = (android.widget.ImageView) bindings[3];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static PrimaryWeatherInfoBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static PrimaryWeatherInfoBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<PrimaryWeatherInfoBinding>inflate(inflater, com.example.android.sunshine.R.layout.primary_weather_info, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static PrimaryWeatherInfoBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static PrimaryWeatherInfoBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.android.sunshine.R.layout.primary_weather_info, null, false), bindingComponent);
    }
    @NonNull
    public static PrimaryWeatherInfoBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static PrimaryWeatherInfoBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/primary_weather_info_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new PrimaryWeatherInfoBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}