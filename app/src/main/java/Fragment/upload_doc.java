package Fragment;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;

import android.content.ActivityNotFoundException;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.graphics.Bitmap;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;

import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.chintu.Gops.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import hari.bounceview.BounceView;


/**
 * A simple {@link Fragment} subclass.
 */
public class upload_doc extends android.app.Fragment {
    private static final int RESULT_CANCELED = 0;
    Button nxt, c1, c2, c3;
    TextView tv, tv1, tv2, tv3;
    ImageView iv, iv5, iv6, iv7;
    private static final String IMAGE_DIRECTORY = "/demonuts";
    private int GALLERY = 1, CAMERA = 2;
    private int a;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_upload_doc, container, false);
        nxt = v.findViewById(R.id.next1);
        c1 = v.findViewById(R.id.camera1);
        c2 = v.findViewById(R.id.camera2);
        c3 = v.findViewById(R.id.camera3);
        iv = v.findViewById(R.id.updoc);
        tv = v.findViewById(R.id.title6);
        tv1 = v.findViewById(R.id.up);
        tv2 = v.findViewById(R.id.us);
        tv3 = v.findViewById(R.id.ui);
        iv5 = v.findViewById(R.id.imageView5);
        iv6 = v.findViewById(R.id.imageView6);
        iv7 = v.findViewById(R.id.imageView7);

        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation animation2 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation3 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation4 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation5 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation6 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation7 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation8 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);

        iv.startAnimation(animation);
        tv.startAnimation(animation1);
        tv1.startAnimation(animation2);
        c1.startAnimation(animation3);
        tv2.startAnimation(animation4);
        c2.startAnimation(animation5);
        tv3.startAnimation(animation6);
        c3.startAnimation(animation7);
        nxt.startAnimation(animation8);


        BounceView.addAnimTo(nxt);
        BounceView.addAnimTo(c1);
        BounceView.addAnimTo(c2);

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Summary summary = new Summary();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.h_m, summary);
                ft.addToBackStack("hello");
                ft.commit();


            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPictureDialog();
                a = 1;


            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPictureDialog();
                a = 2;
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPictureDialog();
                a = 3;
            }
        });

        return v;
    }

    private void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(getActivity());
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), contentURI);
                    String path = saveImage(bitmap);
                    Toast.makeText(getActivity(), "Image Saved!", Toast.LENGTH_SHORT).show();
                    if (a == 1) {
                        iv5.setImageBitmap(bitmap);
                    } else if (a == 2) {
                        iv6.setImageBitmap(bitmap);
                    } else if (a == 3) {
                        iv7.setImageBitmap(bitmap);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            if (a == 1) {
                iv5.setImageBitmap(thumbnail);
                saveImage(thumbnail);
                Toast.makeText(getActivity(), "Image Saved!", Toast.LENGTH_SHORT).show();
            } else if (a == 2) {
                iv6.setImageBitmap(thumbnail);
                saveImage(thumbnail);
                Toast.makeText(getActivity(), "Image Saved!", Toast.LENGTH_SHORT).show();
            } else if (a == 3) {
                iv7.setImageBitmap(thumbnail);
                saveImage(thumbnail);
                Toast.makeText(getActivity(), "Image Saved!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(getActivity(),
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }

    private void requestMultiplePermissions() {
        Dexter.withActivity(getActivity())
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            Toast.makeText(getActivity(), "All permissions are granted by user!", Toast.LENGTH_SHORT).show();
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            //openSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getActivity(), "Some Error! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }

}
