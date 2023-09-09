import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

class test extends JFrame {
    test() {
        setResizable(false); // không cho mở maximum
        Font font = new Font("Arial", Font.PLAIN, 20); // set font
        ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/pic1.png"))); // chèn ảnh
        JLabel container1 = new JLabel(img); // tạo 1 label để chứa ảnh
        JLabel jtext = new JLabel("<html>Chi tiết: Áo thun thời trang có in chữ 'BlackPink'<br><br>Xuất xứ: Hàn Quốc<br><br>Chất liệu: Cotton, Sợi tổng hợp<br><br>Gửi từ: Seul" +
                "<br><br>Mẫu: Trơn<br><br>Kho hàng: 2470<br><br>Thiết kế hiện đại, trẻ trung năng động"); // thông tin mô tả chi tiết
        jtext.setFont(new Font("Arial", Font.PLAIN, 15));
        jtext.setVisible(false); // đặt mặc định là ẩn đi, khi hover vào thì xuất hiện lại

        // set tên, giá, số lượng và size
        JLabel jLabelTen = new JLabel("Tên sản phẩm: ");
        jLabelTen.setFont(font);
        jLabelTen.setHorizontalAlignment(JLabel.LEADING);
        jLabelTen.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_name.png"))));
        JLabel jPanelTenSp = new JLabel("Áo thun");
        jPanelTenSp.setFont(font);

        JLabel jLabelGia = new JLabel("Giá: ");
        jLabelGia.setFont(font);
        jLabelGia.setHorizontalAlignment(JLabel.LEADING);
        jLabelGia.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_price.png"))));
        JLabel jPanelGiaSp = new JLabel("199000");
        jPanelGiaSp.setFont(font);

        JLabel jLabelSLg = new JLabel("Số lượng:");
        jLabelSLg.setFont(font);
        jLabelSLg.setHorizontalAlignment(JLabel.LEADING);
        jLabelSLg.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_inventory.png"))));
        JLabel jPanelsLgSp = new JLabel("10000");
        jPanelsLgSp.setFont(font);

        // set 4 cái radiobutton cho 4 size
        JRadioButton jRadioButton1 = new JRadioButton("Size M");
        jRadioButton1.setFont(font);
        jRadioButton1.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton2 = new JRadioButton("Size L");
        jRadioButton2.setFont(font);
        jRadioButton2.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton3 = new JRadioButton("Size XL");
        jRadioButton3.setFont(font);
        jRadioButton3.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton4 = new JRadioButton("Size XXL");
        jRadioButton4.setFont(font);
        jRadioButton4.setBackground(new Color(234,224,218));

        ButtonGroup bg = new ButtonGroup(); // buttongroup để cho chỉ được chọn 1 cái radioButton
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        bg.add(jRadioButton3);
        bg.add(jRadioButton4);

        JCheckBox jCheckBoxMua = new JCheckBox("Mua");
        jCheckBoxMua.setFont(font);
        jCheckBoxMua.setBackground(new Color(234,224,218));
        JCheckBox jCheckBoxKMua = new JCheckBox("Không mua");
        jCheckBoxKMua.setFont(font);
        jCheckBoxKMua.setBackground(new Color(234,224,218));

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(jCheckBoxMua);
        bg1.add(jCheckBoxKMua);

        // add tất cả các phần tử ở trên vô 1 cái panel
        JPanel jPanelIO = new JPanel();
        jPanelIO.setLayout(new GridLayout(6, 2));
        jPanelIO.setBackground(new Color(234,224,218));
        jPanelIO.add(jLabelTen);
        jPanelIO.add(jPanelTenSp);
        jPanelIO.add(jLabelGia);
        jPanelIO.add(jPanelGiaSp);
        jPanelIO.add(jLabelSLg);
        jPanelIO.add(jPanelsLgSp);
        jPanelIO.add(jRadioButton1);
        jPanelIO.add(jRadioButton2);
        jPanelIO.add(jRadioButton3);
        jPanelIO.add(jRadioButton4);
        jPanelIO.add(jCheckBoxMua);
        jPanelIO.add(jCheckBoxKMua);

        // đặt icon cho các nút
        JButton btnNext = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_next.png"))));
        btnNext.setBackground(new Color(160,195,210));
        JButton btnBack = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_back.png"))));
        btnBack.setBackground(new Color(160,195,210));
        JButton btnMua = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_purchase.png"))));
        btnMua.setBackground(new Color(160,195,210));
        btnBack.setEnabled(false); // vì là trang đầu nên không có nút quay lại
        btnMua.setEnabled(false); // nút mua đặt false enable để khi tick xong hết các ô trong trang mua thì mới true lại

        // tạo 1 cái panel để chứa 3 button
        JPanel gbtn = new JPanel();
        gbtn.setLayout(new GridLayout(1,3));
        gbtn.add(btnBack);
        gbtn.add(btnMua);
        gbtn.add(btnNext);

        JSplitPane PicDes = new JSplitPane(JSplitPane.VERTICAL_SPLIT); // chia đôi trên dưới
        PicDes.add(container1);
        PicDes.add(jtext);
        PicDes.setDividerLocation(1);
        PicDes.setDividerSize(0);
        PicDes.setBackground(new Color(234,224,218));

        // tạo 1 cái jsplitpane để chia đôi ra
        JSplitPane jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); // chia đôi trái phải
        jSplitPane1.add(PicDes);
        jSplitPane1.add(jPanelIO);
        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setDividerSize(0);


        JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.add(jSplitPane1);
        jSplitPane2.add(gbtn);

        jSplitPane2.setDividerLocation(400);
        jSplitPane2.setDividerSize(0);

        add(jSplitPane2); // thêm những thứ đã tạo ở trên vào frame

        // khi hover vào ảnh thì sẽ ẩn ảnh đi và hiện thông tin chi tiết trên
        container1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jtext.setVisible(true);
                container1.setVisible(false);
            }
        });
        // khi di chuột ra khỏi nó thì ảnh sẽ hiện lại và thông tin chi tiết sẽ ẩn đi
        jPanelIO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jtext.setVisible(false);
                container1.setVisible(true);
            }
        });
        // qua trang mới
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test1 t1 = new test1();
                t1.setVisible(true);
                t1.setLocationRelativeTo(null);
                dispose();
            }
        });

        // khi ấn hết các nút trong trang mua bán thì nút Mua mới enable
        jCheckBoxMua.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1 && (jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected() || jRadioButton4.isSelected())) {
                    btnMua.setEnabled(true);
                }
                else {
                    btnMua.setEnabled(false);
                }
            }
        });

        // thay đổi màu khi hover
        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnNext.setBackground(new Color(0,129,201));
            }
        });
        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnNext.setBackground(new Color(160,195,210));
            }
        });

        // chuyển sang trang thanh toán
        btnMua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton1.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton1.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else if (jRadioButton2.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton2.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else if (jRadioButton3.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton3.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton4.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                }
            }
        });
        setTitle("SHOP BÁN HÀNG");
        //setLocationRelativeTo(); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new test();
    }
}
class hoaDon extends JFrame {

    hoaDon(String tens, String gias, String sizes) {
        Font font = new Font("Arial", Font.PLAIN, 15);
        JPanel jPanelSp = new JPanel();
        jPanelSp.setLayout(new GridLayout(5,2));
        JLabel ten = new JLabel("Tên: ");
        ten.setFont(font);
        ten.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_name.png"))));
        JLabel tensp = new JLabel(tens);
        tensp.setFont(font);

        JLabel gia = new JLabel("Giá (x1): ");
        gia.setFont(font);
        gia.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_price.png"))));
        JLabel giasp = new JLabel(gias);
        giasp.setFont(font);

        JLabel size = new JLabel("Size: ");
        size.setFont(font);
        size.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_size.png"))));
        JLabel sizesp = new JLabel(sizes);
        sizesp.setFont(font);

        JLabel soLg = new JLabel("Số lượng: ");
        soLg.setFont(font);
        soLg.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_sl.png"))));
        JSpinner soLgsp = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        soLgsp.setFont(font);

        JLabel sum = new JLabel("Thành tiền(VND):");
        sum.setFont(font);
        sum.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_money.png"))));
        JLabel sumsp = new JLabel(gias);
        sumsp.setFont(font);

        soLgsp.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int x = (Integer)soLgsp.getValue();
                int y = Integer.valueOf(giasp.getText());
                sumsp.setText(x * y + "");
            }
        });
        jPanelSp.add(ten);
        jPanelSp.add(tensp);
        jPanelSp.add(gia);
        jPanelSp.add(giasp);
        jPanelSp.add(size);
        jPanelSp.add(sizesp);
        jPanelSp.add(soLg);
        jPanelSp.add(soLgsp);
        jPanelSp.add(sum);
        jPanelSp.add(sumsp);
        jPanelSp.setBackground(new Color(234,224,218));

        JPanel jPanelUser = new JPanel();
        jPanelUser.setLayout(new GridLayout(6,1, 10,10));
        jPanelUser.setBackground(new Color(234,224,218));
        JLabel tenUser = new JLabel("Họ tên người nhận");
        tenUser.setFont(font);
        tenUser.setHorizontalAlignment(JLabel.CENTER);
        JTextField tenUser1 = new JTextField();
        tenUser1.setFont(font);
        JLabel sdtUser = new JLabel("Số điện thoại");
        sdtUser.setFont(font);
        sdtUser.setHorizontalAlignment(JLabel.CENTER);
        JTextField sdtUser1 = new JTextField();
        sdtUser1.setFont(font);
        JLabel dcUsers = new JLabel("Địa chỉ");
        dcUsers.setFont(font);
        dcUsers.setHorizontalAlignment(JLabel.CENTER);
        JTextField dcUsers1 = new JTextField();
        dcUsers1.setFont(font);

        jPanelUser.add(tenUser);
        jPanelUser.add(tenUser1);
        jPanelUser.add(sdtUser);
        jPanelUser.add(sdtUser1);
        jPanelUser.add(dcUsers);
        jPanelUser.add(dcUsers1);

        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jSplitPane.add(jPanelSp);
        jSplitPane.add(jPanelUser);
        jSplitPane.setDividerSize(0);
        jSplitPane.setDividerLocation(290);

        JPanel jPanelBtn = new JPanel();
        jPanelBtn.setLayout(new GridLayout(1,2));
        JButton jBtnHuy = new JButton("Hủy");
        jBtnHuy.setFont(new Font("Arial", Font.PLAIN,20));
        jBtnHuy.setBackground(new Color(160,195,210));
        JButton jBtnXacNhan = new JButton("Xác nhận");
        jBtnXacNhan.setFont(new Font("Arial", Font.PLAIN,20));
        jBtnXacNhan.setBackground(new Color(160,195,210));
        jPanelBtn.add(jBtnHuy);
        jPanelBtn.add(jBtnXacNhan);

        jBtnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test t = new test();
                t.setVisible(true);
                t.setLocationRelativeTo(null);
                dispose();
            }
        });

        jBtnHuy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jBtnHuy.setBackground(new Color(0,129,201));
            }
        });
        jBtnHuy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                jBtnHuy.setBackground(new Color(160,195,210));
            }
        });

        jBtnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Bạn đã mua hàng thành công", "Congratulation",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        jBtnXacNhan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jBtnXacNhan.setBackground(new Color(0,129,201));
            }
        });
        jBtnXacNhan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                jBtnXacNhan.setBackground(new Color(160,195,210));
            }
        });

        JLabel hoaDon = new JLabel("Hóa đơn");
        hoaDon.setFont(new Font("Arial", Font.BOLD, 40));
        hoaDon.setHorizontalAlignment(JLabel.CENTER);
        hoaDon.setBackground(new Color(234,224,218));


        JSplitPane jSplitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.add(hoaDon);
        jSplitPane1.add(jSplitPane);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setDividerLocation(50);

        JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        jSplitPane2.add(jSplitPane1);
        jSplitPane2.add(jPanelBtn);
        jSplitPane2.setDividerLocation(400);
        jSplitPane2.setDividerSize(0);
        add(jSplitPane2);
        setTitle("SHOP BÁN HÀNG");
        //setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
    }

}
class test1 extends JFrame {
    test1() {
        setResizable(false); // không cho mở maximum
        Font font = new Font("Arial", Font.PLAIN, 20); // set font
        ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/pic2.png"))); // chèn ảnh
        JLabel container1 = new JLabel(img); // tạo 1 label để chứa ảnh
        JLabel jtext = new JLabel("<html>Phong cách: Đường phố, Retro<br><br>Xuất xứ: Hàn Quốc<br><br>Chất liệu: Cotton, Sợi tổng hợp<br><br>Gửi từ: Hà Nội" +
                "<br><br>Mẫu: Trơn<br><br>Kho hàng: 4170<br><br>Thiết kế hiện đại, trẻ trung năng động"); // thông tin mô tả chi tiết
        jtext.setFont(new Font("Arial", Font.PLAIN, 15));
        jtext.setVisible(false); // đặt mặc định là ẩn đi, khi hover vào thì xuất hiện lại

        // set tên, giá, số lượng và size
        JLabel jLabelTen = new JLabel("Tên sản phẩm: ");
        jLabelTen.setFont(font);
        jLabelTen.setHorizontalAlignment(JLabel.LEADING);
        jLabelTen.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_name.png"))));
        JLabel jPanelTenSp = new JLabel("Áo cardigan croptop");
        jPanelTenSp.setFont(font);

        JLabel jLabelGia = new JLabel("Giá: ");
        jLabelGia.setFont(font);
        jLabelGia.setHorizontalAlignment(JLabel.LEADING);
        jLabelGia.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_price.png"))));
        JLabel jPanelGiaSp = new JLabel("99000");
        jPanelGiaSp.setFont(font);

        JLabel jLabelSLg = new JLabel("Số lượng:");
        jLabelSLg.setFont(font);
        jLabelSLg.setHorizontalAlignment(JLabel.LEADING);
        jLabelSLg.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_inventory.png"))));
        JLabel jPanelsLgSp = new JLabel("1000");
        jPanelsLgSp.setFont(font);

        // set 4 cái radiobutton cho 4 size
        JRadioButton jRadioButton1 = new JRadioButton("Size M");
        jRadioButton1.setFont(font);
        jRadioButton1.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton2 = new JRadioButton("Size L");
        jRadioButton2.setFont(font);
        jRadioButton2.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton3 = new JRadioButton("Size XL");
        jRadioButton3.setFont(font);
        jRadioButton3.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton4 = new JRadioButton("Size XXL");
        jRadioButton4.setFont(font);
        jRadioButton4.setBackground(new Color(234,224,218));

        ButtonGroup bg = new ButtonGroup(); // buttongroup để cho chỉ được chọn 1 cái radioButton
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        bg.add(jRadioButton3);
        bg.add(jRadioButton4);

        JCheckBox jCheckBoxMua = new JCheckBox("Mua");
        jCheckBoxMua.setFont(font);
        jCheckBoxMua.setBackground(new Color(234,224,218));
        JCheckBox jCheckBoxKMua = new JCheckBox("Không mua");
        jCheckBoxKMua.setFont(font);
        jCheckBoxKMua.setBackground(new Color(234,224,218));

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(jCheckBoxMua);
        bg1.add(jCheckBoxKMua);

        // add tất cả các phần tử ở trên vô 1 cái panel
        JPanel jPanelIO = new JPanel();
        jPanelIO.setLayout(new GridLayout(6, 2));
        jPanelIO.setBackground(new Color(234,224,218));
        jPanelIO.add(jLabelTen);
        jPanelIO.add(jPanelTenSp);
        jPanelIO.add(jLabelGia);
        jPanelIO.add(jPanelGiaSp);
        jPanelIO.add(jLabelSLg);
        jPanelIO.add(jPanelsLgSp);
        jPanelIO.add(jRadioButton1);
        jPanelIO.add(jRadioButton2);
        jPanelIO.add(jRadioButton3);
        jPanelIO.add(jRadioButton4);
        jPanelIO.add(jCheckBoxMua);
        jPanelIO.add(jCheckBoxKMua);

        // đặt icon cho các nút
        JButton btnNext = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_next.png"))));
        btnNext.setBackground(new Color(160,195,210));
        JButton btnBack = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_back.png"))));
        btnBack.setBackground(new Color(160,195,210));
        JButton btnMua = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_purchase.png"))));
        btnMua.setBackground(new Color(160,195,210));
        btnBack.setEnabled(true); // vì là trang 2 nên có nút quay lại
        btnMua.setEnabled(false); // nút mua đặt false enable để khi tick xong hết các ô trong trang mua thì mới true lại

        // tạo 1 cái panel để chứa 3 button
        JPanel gbtn = new JPanel();
        gbtn.setLayout(new GridLayout(1,3));
        gbtn.add(btnBack);
        gbtn.add(btnMua);
        gbtn.add(btnNext);

        JSplitPane PicDes = new JSplitPane(JSplitPane.VERTICAL_SPLIT); // chia đôi trên dưới
        PicDes.add(container1);
        PicDes.add(jtext);
        PicDes.setDividerLocation(1);
        PicDes.setDividerSize(0);
        PicDes.setBackground(new Color(234,224,218));

        // tạo 1 cái jsplitpane để chia đôi ra
        JSplitPane jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); // chia đôi trái phải
        jSplitPane1.add(PicDes);
        jSplitPane1.add(jPanelIO);
        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setDividerSize(0);


        JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.add(jSplitPane1);
        jSplitPane2.add(gbtn);

        jSplitPane2.setDividerLocation(400);
        jSplitPane2.setDividerSize(0);

        add(jSplitPane2); // thêm những thứ đã tạo ở trên vào frame

        // khi hover vào ảnh thì sẽ ẩn ảnh đi và hiện thông tin chi tiết trên
        container1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jtext.setVisible(true);
                container1.setVisible(false);
            }
        });
        // khi di chuột ra khỏi nó thì ảnh sẽ hiện lại và thông tin chi tiết sẽ ẩn đi
        jPanelIO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jtext.setVisible(false);
                container1.setVisible(true);
            }
        });
        // qua trang mới
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test2 t2 = new test2();
                t2.setVisible(true);
                t2.setLocationRelativeTo(null);
                dispose();
            }
        });
        // quay về trang
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test t = new test();
                t.setVisible(true);
                t.setLocationRelativeTo(null);
                dispose();
            }
        });

        // khi ấn hết các nút trong trang mua bán thì nút Mua mới enable
        jCheckBoxMua.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1 && (jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected() || jRadioButton4.isSelected())) {
                    btnMua.setEnabled(true);
                }
                else {
                    btnMua.setEnabled(false);
                }
            }
        });

        // thay đổi màu khi hover
        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnNext.setBackground(new Color(0,129,201));
            }
        });
        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnNext.setBackground(new Color(160,195,210));
            }
        });

        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnBack.setBackground(new Color(0,129,201));
            }
        });
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnBack.setBackground(new Color(160,195,210));
            }
        });

        // chuyển sang trang thanh toán
        btnMua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton1.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton1.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else if (jRadioButton2.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton2.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else if (jRadioButton3.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton3.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton4.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                }
            }
        });
        setTitle("SHOP BÁN HÀNG");
        //setLocationRelativeTo(); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new test();
    }
}
class test2 extends JFrame {
    test2() {
        setResizable(false); // không cho mở maximum
        Font font = new Font("Arial", Font.PLAIN, 20); // set font
        ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/pic3.png"))); // chèn ảnh
        JLabel container1 = new JLabel(img); // tạo 1 label để chứa ảnh
        JLabel jtext = new JLabel("<html>Phong cách: Quần thời trang<br><br>Xuất xứ: Việt Nam<br><br>Chất liệu: Demin<br><br>Gửi từ: TP. Hồ Chí Minh" +
                "<br><br>Mẫu: Trơn<br><br>Kho hàng: 5670<br><br>Thiết kế hiện đại, cổ điển năng động"); // thông tin mô tả chi tiết
        jtext.setFont(new Font("Arial", Font.PLAIN, 15));
        jtext.setVisible(false); // đặt mặc định là ẩn đi, khi hover vào thì xuất hiện lại

        // set tên, giá, số lượng và size
        JLabel jLabelTen = new JLabel("Tên sản phẩm: ");
        jLabelTen.setFont(font);
        jLabelTen.setHorizontalAlignment(JLabel.LEADING);
        jLabelTen.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_name.png"))));
        JLabel jPanelTenSp = new JLabel("Quần bò Jean");
        jPanelTenSp.setFont(font);

        JLabel jLabelGia = new JLabel("Giá: ");
        jLabelGia.setFont(font);
        jLabelGia.setHorizontalAlignment(JLabel.LEADING);
        jLabelGia.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_price.png"))));
        JLabel jPanelGiaSp = new JLabel("149000");
        jPanelGiaSp.setFont(font);

        JLabel jLabelSLg = new JLabel("Số lượng:");
        jLabelSLg.setFont(font);
        jLabelSLg.setHorizontalAlignment(JLabel.LEADING);
        jLabelSLg.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_inventory.png"))));
        JLabel jPanelsLgSp = new JLabel("10000");
        jPanelsLgSp.setFont(font);

        // set 4 cái radiobutton cho 4 size
        JRadioButton jRadioButton1 = new JRadioButton("Size M");
        jRadioButton1.setFont(font);
        jRadioButton1.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton2 = new JRadioButton("Size L");
        jRadioButton2.setFont(font);
        jRadioButton2.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton3 = new JRadioButton("Size XL");
        jRadioButton3.setFont(font);
        jRadioButton3.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton4 = new JRadioButton("Size XXL");
        jRadioButton4.setFont(font);
        jRadioButton4.setBackground(new Color(234,224,218));

        ButtonGroup bg = new ButtonGroup(); // buttongroup để cho chỉ được chọn 1 cái radioButton
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        bg.add(jRadioButton3);
        bg.add(jRadioButton4);

        JCheckBox jCheckBoxMua = new JCheckBox("Mua");
        jCheckBoxMua.setFont(font);
        jCheckBoxMua.setBackground(new Color(234,224,218));
        JCheckBox jCheckBoxKMua = new JCheckBox("Không mua");
        jCheckBoxKMua.setFont(font);
        jCheckBoxKMua.setBackground(new Color(234,224,218));

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(jCheckBoxMua);
        bg1.add(jCheckBoxKMua);

        // add tất cả các phần tử ở trên vô 1 cái panel
        JPanel jPanelIO = new JPanel();
        jPanelIO.setLayout(new GridLayout(6, 2));
        jPanelIO.setBackground(new Color(234,224,218));
        jPanelIO.add(jLabelTen);
        jPanelIO.add(jPanelTenSp);
        jPanelIO.add(jLabelGia);
        jPanelIO.add(jPanelGiaSp);
        jPanelIO.add(jLabelSLg);
        jPanelIO.add(jPanelsLgSp);
        jPanelIO.add(jRadioButton1);
        jPanelIO.add(jRadioButton2);
        jPanelIO.add(jRadioButton3);
        jPanelIO.add(jRadioButton4);
        jPanelIO.add(jCheckBoxMua);
        jPanelIO.add(jCheckBoxKMua);

        // đặt icon cho các nút
        JButton btnNext = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_next.png"))));
        btnNext.setBackground(new Color(160,195,210));
        JButton btnBack = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_back.png"))));
        btnBack.setBackground(new Color(160,195,210));
        JButton btnMua = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_purchase.png"))));
        btnMua.setBackground(new Color(160,195,210));
        btnBack.setEnabled(true); // vì là trang 2 nên có nút quay lại
        btnMua.setEnabled(false); // nút mua đặt false enable để khi tick xong hết các ô trong trang mua thì mới true lại

        // tạo 1 cái panel để chứa 3 button
        JPanel gbtn = new JPanel();
        gbtn.setLayout(new GridLayout(1,3));
        gbtn.add(btnBack);
        gbtn.add(btnMua);
        gbtn.add(btnNext);

        JSplitPane PicDes = new JSplitPane(JSplitPane.VERTICAL_SPLIT); // chia đôi trên dưới
        PicDes.add(container1);
        PicDes.add(jtext);
        PicDes.setDividerLocation(1);
        PicDes.setDividerSize(0);
        PicDes.setBackground(new Color(234,224,218));

        // tạo 1 cái jsplitpane để chia đôi ra
        JSplitPane jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); // chia đôi trái phải
        jSplitPane1.add(PicDes);
        jSplitPane1.add(jPanelIO);
        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setDividerSize(0);


        JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.add(jSplitPane1);
        jSplitPane2.add(gbtn);

        jSplitPane2.setDividerLocation(400);
        jSplitPane2.setDividerSize(0);

        add(jSplitPane2); // thêm những thứ đã tạo ở trên vào frame

        // khi hover vào ảnh thì sẽ ẩn ảnh đi và hiện thông tin chi tiết trên
        container1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jtext.setVisible(true);
                container1.setVisible(false);
            }
        });
        // khi di chuột ra khỏi nó thì ảnh sẽ hiện lại và thông tin chi tiết sẽ ẩn đi
        jPanelIO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jtext.setVisible(false);
                container1.setVisible(true);
            }
        });
        // qua trang mới
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test3 t3 = new test3();
                t3.setVisible(true);
                t3.setLocationRelativeTo(null);
                dispose();
            }
        });
        // quay về trang
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test1 t1 = new test1();
                t1.setVisible(true);
                t1.setLocationRelativeTo(null);
                dispose();
            }
        });

        // khi ấn hết các nút trong trang mua bán thì nút Mua mới enable
        jCheckBoxMua.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1 && (jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected() || jRadioButton4.isSelected())) {
                    btnMua.setEnabled(true);
                }
                else {
                    btnMua.setEnabled(false);
                }
            }
        });

        // thay đổi màu khi hover
        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnNext.setBackground(new Color(0,129,201));
            }
        });
        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnNext.setBackground(new Color(160,195,210));
            }
        });

        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnBack.setBackground(new Color(0,129,201));
            }
        });
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnBack.setBackground(new Color(160,195,210));
            }
        });

        // chuyển sang trang thanh toán
        btnMua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton1.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton1.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else if (jRadioButton2.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton2.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else if (jRadioButton3.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton3.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton4.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                }
            }
        });
        setTitle("SHOP BÁN HÀNG");
        //setLocationRelativeTo(); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new test();
    }
}
class test3 extends JFrame {
    test3() {
        setResizable(false); // không cho mở maximum
        Font font = new Font("Arial", Font.PLAIN, 20); // set font
        ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/pic4.png"))); // chèn ảnh
        JLabel container1 = new JLabel(img); // tạo 1 label để chứa ảnh
        JLabel jtext = new JLabel("<html>Thương hiệu: Áo len Celine<br><br>Xuất xứ: Hàn Quốc<br><br>Chất liệu: Len<br><br>Gửi từ: Seul" +
                "<br><br>Mẫu: Len<br><br>Kho hàng: 9470<br><br>Thiết kế hiện đại, trẻ trung, ấm áo, rất thích hợp cho mùa đông lạnh"); // thông tin mô tả chi tiết
        jtext.setFont(new Font("Arial", Font.PLAIN, 15));
        jtext.setVisible(false); // đặt mặc định là ẩn đi, khi hover vào thì xuất hiện lại

        // set tên, giá, số lượng và size
        JLabel jLabelTen = new JLabel("Tên sản phẩm: ");
        jLabelTen.setFont(font);
        jLabelTen.setHorizontalAlignment(JLabel.LEADING);
        jLabelTen.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_name.png"))));
        JLabel jPanelTenSp = new JLabel("Áo len chùm đầu");
        jPanelTenSp.setFont(font);

        JLabel jLabelGia = new JLabel("Giá: ");
        jLabelGia.setFont(font);
        jLabelGia.setHorizontalAlignment(JLabel.LEADING);
        jLabelGia.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_price.png"))));
        JLabel jPanelGiaSp = new JLabel("999000");
        jPanelGiaSp.setFont(font);

        JLabel jLabelSLg = new JLabel("Số lượng:");
        jLabelSLg.setFont(font);
        jLabelSLg.setHorizontalAlignment(JLabel.LEADING);
        jLabelSLg.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_inventory.png"))));
        JLabel jPanelsLgSp = new JLabel("80099");
        jPanelsLgSp.setFont(font);

        // set 4 cái radiobutton cho 4 size
        JRadioButton jRadioButton1 = new JRadioButton("Size M");
        jRadioButton1.setFont(font);
        jRadioButton1.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton2 = new JRadioButton("Size L");
        jRadioButton2.setFont(font);
        jRadioButton2.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton3 = new JRadioButton("Size XL");
        jRadioButton3.setFont(font);
        jRadioButton3.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton4 = new JRadioButton("Size XXL");
        jRadioButton4.setFont(font);
        jRadioButton4.setBackground(new Color(234,224,218));

        ButtonGroup bg = new ButtonGroup(); // buttongroup để cho chỉ được chọn 1 cái radioButton
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        bg.add(jRadioButton3);
        bg.add(jRadioButton4);

        JCheckBox jCheckBoxMua = new JCheckBox("Mua");
        jCheckBoxMua.setFont(font);
        jCheckBoxMua.setBackground(new Color(234,224,218));
        JCheckBox jCheckBoxKMua = new JCheckBox("Không mua");
        jCheckBoxKMua.setFont(font);
        jCheckBoxKMua.setBackground(new Color(234,224,218));

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(jCheckBoxMua);
        bg1.add(jCheckBoxKMua);

        // add tất cả các phần tử ở trên vô 1 cái panel
        JPanel jPanelIO = new JPanel();
        jPanelIO.setLayout(new GridLayout(6, 2));
        jPanelIO.setBackground(new Color(234,224,218));
        jPanelIO.add(jLabelTen);
        jPanelIO.add(jPanelTenSp);
        jPanelIO.add(jLabelGia);
        jPanelIO.add(jPanelGiaSp);
        jPanelIO.add(jLabelSLg);
        jPanelIO.add(jPanelsLgSp);
        jPanelIO.add(jRadioButton1);
        jPanelIO.add(jRadioButton2);
        jPanelIO.add(jRadioButton3);
        jPanelIO.add(jRadioButton4);
        jPanelIO.add(jCheckBoxMua);
        jPanelIO.add(jCheckBoxKMua);

        // đặt icon cho các nút
        JButton btnNext = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_next.png"))));
        btnNext.setBackground(new Color(160,195,210));
        JButton btnBack = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_back.png"))));
        btnBack.setBackground(new Color(160,195,210));
        JButton btnMua = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_purchase.png"))));
        btnMua.setBackground(new Color(160,195,210));
        btnBack.setEnabled(true); // vì là trang 2 nên có nút quay lại
        btnMua.setEnabled(false); // nút mua đặt false enable để khi tick xong hết các ô trong trang mua thì mới true lại

        // tạo 1 cái panel để chứa 3 button
        JPanel gbtn = new JPanel();
        gbtn.setLayout(new GridLayout(1,3));
        gbtn.add(btnBack);
        gbtn.add(btnMua);
        gbtn.add(btnNext);

        JSplitPane PicDes = new JSplitPane(JSplitPane.VERTICAL_SPLIT); // chia đôi trên dưới
        PicDes.add(container1);
        PicDes.add(jtext);
        PicDes.setDividerLocation(1);
        PicDes.setDividerSize(0);
        PicDes.setBackground(new Color(234,224,218));

        // tạo 1 cái jsplitpane để chia đôi ra
        JSplitPane jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); // chia đôi trái phải
        jSplitPane1.add(PicDes);
        jSplitPane1.add(jPanelIO);
        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setDividerSize(0);


        JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.add(jSplitPane1);
        jSplitPane2.add(gbtn);

        jSplitPane2.setDividerLocation(400);
        jSplitPane2.setDividerSize(0);

        add(jSplitPane2); // thêm những thứ đã tạo ở trên vào frame

        // khi hover vào ảnh thì sẽ ẩn ảnh đi và hiện thông tin chi tiết trên
        container1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jtext.setVisible(true);
                container1.setVisible(false);
            }
        });
        // khi di chuột ra khỏi nó thì ảnh sẽ hiện lại và thông tin chi tiết sẽ ẩn đi
        jPanelIO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jtext.setVisible(false);
                container1.setVisible(true);
            }
        });
        // qua trang mới
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test4 t4 = new test4();
                t4.setVisible(true);
                t4.setLocationRelativeTo(null);
                dispose();
            }
        });
        // quay về trang
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test2 t2 = new test2();
                t2.setVisible(true);
                t2.setLocationRelativeTo(null);
                dispose();
            }
        });

        // khi ấn hết các nút trong trang mua bán thì nút Mua mới enable
        jCheckBoxMua.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1 && (jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected() || jRadioButton4.isSelected())) {
                    btnMua.setEnabled(true);
                }
                else {
                    btnMua.setEnabled(false);
                }
            }
        });

        // thay đổi màu khi hover
        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnNext.setBackground(new Color(0,129,201));
            }
        });
        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnNext.setBackground(new Color(160,195,210));
            }
        });

        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnBack.setBackground(new Color(0,129,201));
            }
        });
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnBack.setBackground(new Color(160,195,210));
            }
        });

        // chuyển sang trang thanh toán
        btnMua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton1.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton1.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else if (jRadioButton2.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton2.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else if (jRadioButton3.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton3.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton4.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                }
            }
        });
        setTitle("SHOP BÁN HÀNG");
        //setLocationRelativeTo(); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new test();
    }
}
class test4 extends JFrame {
    test4() {
        setResizable(false); // không cho mở maximum
        Font font = new Font("Arial", Font.PLAIN, 20); // set font
        ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/pic5.png"))); // chèn ảnh
        JLabel container1 = new JLabel(img); // tạo 1 label để chứa ảnh
        JLabel jtext = new JLabel("<html>Phong cách: Áo khoác thời trang<br><br>Xuất xứ: Việt Nam<br><br>Chất liệu: Cotton, Sợi bông<br><br>Gửi từ: TP. Hồ Chí Minh" +
                "<br><br>Mẫu: Jean<br><br>Kho hàng: 1234<br><br>Thiết kế hiện đại, trẻ trung năng động"); // thông tin mô tả chi tiết
        jtext.setFont(new Font("Arial", Font.PLAIN, 15));
        jtext.setVisible(false); // đặt mặc định là ẩn đi, khi hover vào thì xuất hiện lại

        // set tên, giá, số lượng và size
        JLabel jLabelTen = new JLabel("Tên sản phẩm: ");
        jLabelTen.setFont(font);
        jLabelTen.setHorizontalAlignment(JLabel.LEADING);
        jLabelTen.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_name.png"))));
        JLabel jPanelTenSp = new JLabel("Áo khoác Asus");
        jPanelTenSp.setFont(font);

        JLabel jLabelGia = new JLabel("Giá: ");
        jLabelGia.setFont(font);
        jLabelGia.setHorizontalAlignment(JLabel.LEADING);
        jLabelGia.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_price.png"))));
        JLabel jPanelGiaSp = new JLabel("99000");
        jPanelGiaSp.setFont(font);

        JLabel jLabelSLg = new JLabel("Số lượng:");
        jLabelSLg.setFont(font);
        jLabelSLg.setHorizontalAlignment(JLabel.LEADING);
        jLabelSLg.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_inventory.png"))));
        JLabel jPanelsLgSp = new JLabel("190000");
        jPanelsLgSp.setFont(font);

        // set 4 cái radiobutton cho 4 size
        JRadioButton jRadioButton1 = new JRadioButton("Size M");
        jRadioButton1.setFont(font);
        jRadioButton1.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton2 = new JRadioButton("Size L");
        jRadioButton2.setFont(font);
        jRadioButton2.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton3 = new JRadioButton("Size XL");
        jRadioButton3.setFont(font);
        jRadioButton3.setBackground(new Color(234,224,218));
        JRadioButton jRadioButton4 = new JRadioButton("Size XXL");
        jRadioButton4.setFont(font);
        jRadioButton4.setBackground(new Color(234,224,218));

        ButtonGroup bg = new ButtonGroup(); // buttongroup để cho chỉ được chọn 1 cái radioButton
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        bg.add(jRadioButton3);
        bg.add(jRadioButton4);

        JCheckBox jCheckBoxMua = new JCheckBox("Mua");
        jCheckBoxMua.setFont(font);
        jCheckBoxMua.setBackground(new Color(234,224,218));
        JCheckBox jCheckBoxKMua = new JCheckBox("Không mua");
        jCheckBoxKMua.setFont(font);
        jCheckBoxKMua.setBackground(new Color(234,224,218));

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(jCheckBoxMua);
        bg1.add(jCheckBoxKMua);

        // add tất cả các phần tử ở trên vô 1 cái panel
        JPanel jPanelIO = new JPanel();
        jPanelIO.setLayout(new GridLayout(6, 2));
        jPanelIO.setBackground(new Color(234,224,218));
        jPanelIO.add(jLabelTen);
        jPanelIO.add(jPanelTenSp);
        jPanelIO.add(jLabelGia);
        jPanelIO.add(jPanelGiaSp);
        jPanelIO.add(jLabelSLg);
        jPanelIO.add(jPanelsLgSp);
        jPanelIO.add(jRadioButton1);
        jPanelIO.add(jRadioButton2);
        jPanelIO.add(jRadioButton3);
        jPanelIO.add(jRadioButton4);
        jPanelIO.add(jCheckBoxMua);
        jPanelIO.add(jCheckBoxKMua);

        // đặt icon cho các nút
        JButton btnNext = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_next.png"))));
        btnNext.setBackground(new Color(160,195,210));
        JButton btnBack = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_back.png"))));
        btnBack.setBackground(new Color(160,195,210));
        JButton btnMua = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(test.class.getResource("image/icon_purchase.png"))));
        btnMua.setBackground(new Color(160,195,210));
        btnNext.setEnabled(false); // vì là trang cuối nên không có nút next
        btnMua.setEnabled(false); // nút mua đặt false enable để khi tick xong hết các ô trong trang mua thì mới true lại

        // tạo 1 cái panel để chứa 3 button
        JPanel gbtn = new JPanel();
        gbtn.setLayout(new GridLayout(1,3));
        gbtn.add(btnBack);
        gbtn.add(btnMua);
        gbtn.add(btnNext);

        JSplitPane PicDes = new JSplitPane(JSplitPane.VERTICAL_SPLIT); // chia đôi trên dưới
        PicDes.add(container1);
        PicDes.add(jtext);
        PicDes.setDividerLocation(1);
        PicDes.setDividerSize(0);
        PicDes.setBackground(new Color(234,224,218));

        // tạo 1 cái jsplitpane để chia đôi ra
        JSplitPane jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); // chia đôi trái phải
        jSplitPane1.add(PicDes);
        jSplitPane1.add(jPanelIO);
        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setDividerSize(0);


        JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.add(jSplitPane1);
        jSplitPane2.add(gbtn);

        jSplitPane2.setDividerLocation(400);
        jSplitPane2.setDividerSize(0);

        add(jSplitPane2); // thêm những thứ đã tạo ở trên vào frame

        // khi hover vào ảnh thì sẽ ẩn ảnh đi và hiện thông tin chi tiết trên
        container1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jtext.setVisible(true);
                container1.setVisible(false);
            }
        });
        // khi di chuột ra khỏi nó thì ảnh sẽ hiện lại và thông tin chi tiết sẽ ẩn đi
        jPanelIO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jtext.setVisible(false);
                container1.setVisible(true);
            }
        });

        // quay về trang
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test3 t3 = new test3();
                t3.setVisible(true);
                t3.setLocationRelativeTo(null);
                dispose();
            }
        });

        // khi ấn hết các nút trong trang mua bán thì nút Mua mới enable
        jCheckBoxMua.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1 && (jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected() || jRadioButton4.isSelected())) {
                    btnMua.setEnabled(true);
                }
                else {
                    btnMua.setEnabled(false);
                }
            }
        });

        // thay đổi màu khi hover
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnBack.setBackground(new Color(0,129,201));
            }
        });
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnBack.setBackground(new Color(160,195,210));
            }
        });

        // chuyển sang trang thanh toán
        btnMua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton1.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton1.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else if (jRadioButton2.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton2.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else if (jRadioButton3.isSelected()) {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton3.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                } else {
                    hoaDon hd = new hoaDon(jPanelTenSp.getText(), jPanelGiaSp.getText(), jRadioButton4.getText());
                    hd.setVisible(true);
                    hd.setLocationRelativeTo(null);
                    dispose();
                }
            }
        });
        setTitle("SHOP BÁN HÀNG");
        //setLocationRelativeTo(); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new test();
    }
}
