package de.nigjo.nbm.office.filetypes;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.Desktop;

import org.openide.cookies.OpenCookie;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 * @author Jens Hofschröer
 */
public class ApplicationStarter implements OpenCookie {
  private final FileObject pf;

  public ApplicationStarter(FileObject pf)
  {
    this.pf = pf;
  }

  @Override
  public void open()
  {
    try
    {
      if(Desktop.isDesktopSupported())
      {
        Desktop.getDesktop().open(FileUtil.toFile(pf));
      }
    }
    catch(UnsupportedOperationException | IOException ex)
    {
      // Irgendwas hat nicht funktioniert beim Starten der Anwendung.
      Logger.getLogger(ApplicationStarter.class.getName()).
          log(Level.SEVERE, ex.toString(), ex);
    }
    catch(NullPointerException | IllegalArgumentException ex)
    {
      // Datei nicht (mehr) da.
      Logger.getLogger(ApplicationStarter.class.getName()).
          log(Level.WARNING, ex.toString());
    }
  }

}