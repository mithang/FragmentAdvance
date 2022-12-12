package glaxymedia.fragmentadvance;

import android.support.v4.app.Fragment;

        import android.content.Context;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

/**
 * Created by linhphan on 7/21/16.
 */
public class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(getClass().getName(), "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(getClass().getName(), "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(getClass().getName(), "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(getClass().getName(), "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(getClass().getName(), "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(getClass().getName(), "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(getClass().getName(), "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(getClass().getName(), "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(getClass().getName(), "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(getClass().getName(), "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(getClass().getName(), "onDetach");
    }


}