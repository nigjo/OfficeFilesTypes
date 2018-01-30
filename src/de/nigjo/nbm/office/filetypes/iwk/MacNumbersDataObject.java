package de.nigjo.nbm.office.filetypes.iwk;

import java.io.IOException;

import java.awt.Desktop;

import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.util.NbBundle.Messages;

import de.nigjo.nbm.office.filetypes.ApplicationStarter;

@Messages(
    {
      "LBL_MacNumbers_LOADER=iWork Numbers File"
    })
@MIMEResolver.ExtensionRegistration(
    displayName = "#LBL_MacNumbers_LOADER",
    mimeType = "application/x-iwork-numbers-sffnumbers",
    extension =
    {
      "numbers",
    }
)
@DataObject.Registration(
    mimeType = "application/x-iwork-numbers-sffnumbers",
    iconBase = "de/nigjo/nbm/office/filetypes/iwk/Numbers_Flat.png",
    displayName = "#LBL_MacNumbers_LOADER",
    position = 384
)
@ActionReferences(
    {
      @ActionReference(
          path = "Loaders/application/x-iwork-numbers-sffnumbers/Actions",
          id =
          @ActionID(category = "System", id = "org.openide.actions.OpenAction"),
          position = 100,
          separatorAfter = 200
      ),
      @ActionReference(
          path = "Loaders/application/x-iwork-numbers-sffnumbers/Actions",
          id =
          @ActionID(category = "Edit", id = "org.openide.actions.CutAction"),
          position = 300
      ),
      @ActionReference(
          path = "Loaders/application/x-iwork-numbers-sffnumbers/Actions",
          id =
          @ActionID(category = "Edit", id = "org.openide.actions.CopyAction"),
          position = 400,
          separatorAfter = 500
      ),
      @ActionReference(
          path = "Loaders/application/x-iwork-numbers-sffnumbers/Actions",
          id =
          @ActionID(category = "Edit", id = "org.openide.actions.DeleteAction"),
          position = 600
      ),
      @ActionReference(
          path = "Loaders/application/x-iwork-numbers-sffnumbers/Actions",
          id =
          @ActionID(category = "System", id = "org.openide.actions.RenameAction"),
          position = 700,
          separatorAfter = 800
      ),
      @ActionReference(
          path = "Loaders/application/x-iwork-numbers-sffnumbers/Actions",
          id =
          @ActionID(category = "System", id =
              "org.openide.actions.SaveAsTemplateAction"),
          position = 900,
          separatorAfter = 1000
      ),
      @ActionReference(
          path = "Loaders/application/x-iwork-numbers-sffnumbers/Actions",
          id =
          @ActionID(category = "System", id =
              "org.openide.actions.FileSystemAction"),
          position = 1100,
          separatorAfter = 1200
      ),
      @ActionReference(
          path = "Loaders/application/x-iwork-numbers-sffnumbers/Actions",
          id =
          @ActionID(category = "System", id = "org.openide.actions.ToolsAction"),
          position = 1300
      ),
      @ActionReference(
          path = "Loaders/application/x-iwork-numbers-sffnumbers/Actions",
          id =
          @ActionID(category = "System", id =
              "org.openide.actions.PropertiesAction"),
          position = 1400
      )
    })
public class MacNumbersDataObject extends MultiDataObject
{
  private static final long serialVersionUID = -6981586561927381772L;

  public MacNumbersDataObject(FileObject pf, MultiFileLoader loader)
      throws DataObjectExistsException, IOException
  {
    super(pf, loader);

    if(Desktop.isDesktopSupported())
    {
      getCookieSet().add(new ApplicationStarter(pf));
    }
  }

  @Override
  protected int associateLookup()
  {
    return 1;
  }


}
