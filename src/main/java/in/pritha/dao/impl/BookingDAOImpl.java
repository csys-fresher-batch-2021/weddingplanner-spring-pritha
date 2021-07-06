package in.pritha.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import in.pritha.dao.BookingDAO;
import in.pritha.model.BookingEntity;

@Repository
public class BookingDAOImpl implements BookingDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public BookingEntity cancelBookingDetailsAndTheirEarnedCoins(BookingEntity booking) {

		System.out.println("Procedure method called");
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.VARCHAR), new SqlParameter(Types.BIGINT),
				new SqlParameter(Types.VARCHAR));

		Map<String, Object> t = jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				System.out.println("callable statement executed");
				CallableStatement callableStatement = con.prepareCall("{CALL pr_cancel_booking(?, ?, ?)}");
				callableStatement.setString(1, booking.getUsername());
				callableStatement.setInt(2, booking.getBookingId());
				callableStatement.setString(3, booking.getCancellationReason());

				return callableStatement;
			}
		}, parameters);
		return booking;
	}

	@Override
	public boolean cancelBooking(BookingEntity booking) {
		final String procedureCall = "call pr_cancel_booking(?,?,?,?)";
		boolean result = false;
		try (Connection connection = jdbcTemplate.getDataSource().getConnection()) {
			PreparedStatement prepareStatement = connection.prepareStatement(procedureCall);
			prepareStatement.setString(1, booking.getUsername().toUpperCase());
			prepareStatement.setInt(2, booking.getBookingId());
			prepareStatement.setString(3, booking.getCancellationReason());
			prepareStatement.setString(4, booking.getStatus());
			result = prepareStatement.execute();
			System.out.println("Result :" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public Integer findMyAccount(String username) {
		String sql = "Select get_earned_coins(?)";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class, username.toUpperCase());
		System.out.println("Earned Coins " + count);
		return count;
	}

}
