// Generated code from Butter Knife. Do not modify!
package com.schoolpaymentclient;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.schoolpaymentclient.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296321, "field 'textViewInfo'");
    target.textViewInfo = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296322, "method 'onClickNotif'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickNotif(p0);
        }
      });
    view = finder.findRequiredView(source, 2131296324, "method 'onClickRegistrasi'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickRegistrasi(p0);
        }
      });
    view = finder.findRequiredView(source, 2131296323, "method 'onClickPesan'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickPesan(p0);
        }
      });
  }

  public static void reset(com.schoolpaymentclient.MainActivity target) {
    target.textViewInfo = null;
  }
}
