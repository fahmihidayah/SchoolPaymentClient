// Generated code from Butter Knife. Do not modify!
package com.schoolpaymentclient;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class LoginActivity$$ViewInjector {
  public static void inject(Finder finder, final com.schoolpaymentclient.LoginActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296318, "field 'editTextNim'");
    target.editTextNim = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131296319, "method 'onClickLogin'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickLogin(p0);
        }
      });
  }

  public static void reset(com.schoolpaymentclient.LoginActivity target) {
    target.editTextNim = null;
  }
}
