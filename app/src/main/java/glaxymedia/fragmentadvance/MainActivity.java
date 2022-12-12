package glaxymedia.fragmentadvance;

import android.app.FragmentManager;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private int number = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = (Button) findViewById(R.id.btn_add);
        Button btnReplace = (Button) findViewById(R.id.btn_replace);
        Button btnBack = (Button) findViewById(R.id.btn_back);
        Button btnCheck = (Button) findViewById(R.id.btnCheck);

        btnAdd.setOnClickListener(this);
        btnReplace.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnCheck.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.btn_add:
                //addFragment(R.id.fl_main_content, getFragmentName(), false);
                FragmentA fraA= (FragmentA) getSupportFragmentManager().findFragmentByTag(FragmentA.class.getName());

                if(fraA==null){
                    FragmentA fragment = new FragmentA();
                    transaction.add(R.id.fl_main_content, fragment, FragmentA.class.getName());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else{
                    transaction.show(fraA);
                }
                break;
            case R.id.btn_replace:
                //replaceFragment(R.id.fl_main_content, getFragmentName(), false);
                FragmentB fraB= (FragmentB) getSupportFragmentManager().findFragmentByTag(FragmentB.class.getName());
                if(fraB==null){
                    FragmentB fragment = new FragmentB();
                    transaction.add(R.id.fl_main_content, fragment, fragment.getClass().getName());
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
                else{
                    transaction.show(fraB);
                }
                break;
            case R.id.btn_back:
                onBackPressed();//Khi gọi hàm này mà không xử lí hàm onBackPressed thì khi nhấn nút back nó cũng đóng chương trình
                break;
            case R.id.btnCheck:
                //Log.e("ABC",getFragmentCount()+"");
                FragmentC fraC= (FragmentC) getSupportFragmentManager().findFragmentByTag(FragmentC.class.getName());
                if(fraC==null){
                    FragmentC fragment = new FragmentC();
                    transaction.add(R.id.fl_main_content, fragment, fragment.getClass().getName());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else{
                    transaction.show(fraC);

                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        //Chú ý: Nếu không xử lí hàm này thì khi back dù add hay replace nó điều đóng chương trình
        FragmentManager fm = getFragmentManager();
        //Hàm này bỏ tất cả Fragment mà đã add vào trước đó
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        } else {
            //Hàm này chạy mặt định
            super.onBackPressed();
        }

    }


    //Đếm số lượng Fragment đã add vào
    protected int getFragmentCount() {
        List<Fragment> fragentList = getSupportFragmentManager().getFragments();
        return (fragentList!=null ? fragentList.size():0);
    }
    public <T extends Fragment> void addFragment(@IdRes int containerLayoutId, String className, boolean isAddBackStack){
        Fragment fragment = Fragment.instantiate(this, className, null);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(containerLayoutId, fragment, className);
        if (isAddBackStack) {
            transaction.addToBackStack(className);
        }
        else{
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    public <T extends Fragment>void replaceFragment(@IdRes int containerLayoutId, String className, boolean isAddBackStack){
        Fragment fragment = Fragment.instantiate(this, className);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(containerLayoutId, fragment, className);
        if (isAddBackStack) {
            transaction.addToBackStack(className);
        }
        transaction.commit();
    }

    private String getFragmentName(){

        number = ++number % 2;
        switch (number){
            case 0:
                return FragmentA.class.getName();
            case 1:
                return FragmentA.class.getName();
            default:
                return FragmentA.class.getName();
        }
    }
}
