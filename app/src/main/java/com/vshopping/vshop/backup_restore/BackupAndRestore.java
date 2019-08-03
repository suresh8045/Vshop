package com.vshopping.vshop.backup_restore;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.vshopping.vshop.room.database.VshopDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class BackupAndRestore {

    private final Context context;

    public BackupAndRestore(Context context) {
        this.context = context;
    }

    public static void importDB(Context context) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            if (sd.canWrite()) {
                File backupDB = context.getDatabasePath(VshopDatabase.getDatabaseName());
                String backupDBPath = String.format("%s.bak", VshopDatabase.getDatabaseName());
                File currentDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();

                Toast.makeText(context, "Import successful", Toast.LENGTH_SHORT).show();
               // MyApplication.toastSomething(context, "Import Successful!");
            }else{
                Toast.makeText(context, "importvc  failed", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exportDB(Context context) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String backupDBPath = String.format("%s.bak", VshopDatabase.getDatabaseName());
                File currentDB = context.getDatabasePath(VshopDatabase.getDatabaseName());
                File backupDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();

                Toast.makeText(context, "Backup successful", Toast.LENGTH_SHORT).show();
                //MyApplication.toastSomething(context, "Backup Successful!");
            }else{
                Toast.makeText(context, "Backup failed", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
