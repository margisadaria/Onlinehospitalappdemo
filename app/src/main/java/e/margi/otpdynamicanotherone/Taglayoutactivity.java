package e.margi.otpdynamicanotherone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Taglayoutactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taglayoutactivity);

        /*TabLayout tabLayout = findViewById(R.id.tabLayout1);
        ViewPager viewPager = findViewById(R.id.viewpager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new ChatFragment(),"chat");
        viewPagerAdapter.addFragments(new UserFragment(),"Users");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

        class ViewPagerAdapter extends FragmentPagerAdapter
        {
            private ArrayList<Fragment> fragments;
            private ArrayList<String> titles;


            public ViewPagerAdapter(FragmentManager fm)
            {
                super(fm);
                this.fragments = new ArrayList<>();
                this.titles=new ArrayList<>();

            }

            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount()
            {
                return fragments.size();

            }
            public void addFragments(Fragment fragment,String title)
            {
                fragments.add(fragment);
                titles.add(title);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position)
            {
                return titles.get(position);
            }
        }
    }
*/
    }
}

