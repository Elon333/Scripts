package scripts.combat;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Login;
import org.tribot.api2007.Login.STATE;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Ending;
import org.tribot.script.interfaces.EventBlockingOverride;
import org.tribot.script.interfaces.Painting;
import org.tribot.script.interfaces.Starting;

import scripts.combat.data.Node;
import scripts.combat.data.Utils2;
import scripts.combat.data.Vars;
import scripts.combat.gui.GUI;
import scripts.combat.gui.GuiFXML;
import scripts.combat.paint.Paint;
import scripts.combat.tasks.Bank;
import scripts.combat.tasks.Fight;
import scripts.combat.tasks.Travel;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.dax_api.api_lib.models.DaxCredentials;
import scripts.dax_api.api_lib.models.DaxCredentialsProvider;
import scripts.utilty.AntiBan;
import scripts.utilty.Timer;

@ScriptManifest(authors = { "ELON" }, category = "combat", name = "Elon aio combat")
public class Main extends Script implements Starting, Ending,EventBlockingOverride, Painting {

	private List<Node> combatNodes = Arrays.asList(new Bank(), new Travel(), new Fight());

	private Timer timeoutTimer = new Timer(General.random(480000, 600000));

	private GUI gui;
	private URL css;
	private boolean paint;


	@Override
	public void onStart() {
		DaxWalker.setCredentials(new DaxCredentialsProvider() {
			@Override
			public DaxCredentials getDaxCredentials() {
				return new DaxCredentials("sub_DPjXXzL5DeSiPf", "PUBLIC-KEY");
			}
		});
		AntiBan.create();
		Vars.get().startTime = Timing.currentTimeMillis();
	}



	@Override
	public void run() {

		Utils2.createFolder();
		Utils2.createImageFolder();

		css = Utils2.createCssFile();
		gui = new GUI(GuiFXML.get, css);

		gui.show();

		while (gui.isOpen()) {
			sleep(500);
		}

		// we need the account to be logged in for the next step
		while (Login.getLoginState() != STATE.INGAME)
			sleep(500);

		paint = true;
		Utils2.recordStartExp();
		Paint.getPaintBackgroundLayout();

		while (Vars.get().script && timeoutTimer.isRunning()) {

			for (final Node node : combatNodes) {

				if (Vars.get().script && node.validate()) {

					Utils2.recordExp();

				 if (!Vars.get().nodeName.equals(node.getName())) {
						timeoutTimer.reset();
						General.println(node.getName());
					}

					Vars.get().nodeName = node.getName();

					node.execute();

					if (Utils2.checkExp())
						timeoutTimer.reset();

					if (!timeoutTimer.isRunning()) {
						General.println("Script Timed Out");
						Vars.get().script = false;
					}
				}
				General.sleep(20, 40);
			}
		}
	}



	@Override
	public void onEnd() {
		AntiBan.destroy();
		if (gui != null && gui.isOpen())
			gui.close();
		println("Thanks for using Elon AIO Combat! Please leave feedback on the fourms.");
	}



	@Override
	public void onPaint(Graphics g) {
		if (paint)
			Paint.paint(g);
	}



	@Override
	public OVERRIDE_RETURN overrideKeyEvent(KeyEvent arg0) {
		return null;
	}



	@Override
	public OVERRIDE_RETURN overrideMouseEvent(MouseEvent e) {
		if (e.getButton() == 1) {
			if (Paint.closeButtonArea.contains(e.getPoint()))
				paint = false;
		}
		return OVERRIDE_RETURN.PROCESS;
	}



}