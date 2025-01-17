package dexter;

/**
 * Created by Maaz Ahmad on 6/25/19.
 */
public class Preferences {
  public enum Mode {
    Intentional("0"),
    Legacy("1");
    private String value;
    Mode (String v) { value = v; }
    public String value () { return value; }
  }

  public static class Global {
    public static Mode mode = Mode.Intentional;
    public static int verbosity = 0;
    public static boolean log = false;
    public static boolean use_output_logs = false;
    public static boolean run_frontend = false;
    public static boolean generate_intermediate_files = false;
  }

  public static class Sketch {
    public static class ROI {
      public static boolean lightverif = false;
      public static boolean minisat = false;
    }

    public static class Term {
      public static boolean lightverif = false;
      public static boolean minisat = true;
    }

    public static class Expr {
      public static boolean lightverif = false;
      public static boolean minisat = false;
    }

    public static boolean expr_codegen = false;
    public static boolean lightverif = false;
    public static boolean minisat = false;
    public static boolean slv_parallel = true;
    public static int verbosity = 6;
    public static int cores = 14;
    public static int sim_iters = 1500;
    public static int slv_seed = 1;
    public static int inline_bnd = 8;
    public static int unrolL_bnd = 8;
    public static int inbits_bnd = 2;
    public static int cbits_bnd = 1;
    public static int int_range = 60;
    public static int arr_sz_bnd = 100;

  }

  public static void init (CLIParser parser) {
    Global.log = parser.log();
    Global.verbosity = parser.verbosity();
    Global.mode = parser.mode();
    Global.use_output_logs = parser.use_output_logs();
    Global.run_frontend = !parser.skip_frontend();
    Global.generate_intermediate_files = parser.generate_intermediate_files();
  }

  // To call from clang_frontend
  public static void setVerbosity (int v) {
    Global.verbosity = v;
  }
}